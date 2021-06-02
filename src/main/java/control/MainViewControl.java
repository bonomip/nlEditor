package control;

import javafx.util.Pair;
import model.ProductionDescriptor;
import model.Slice;
import util.Message;
import util.PrettyFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Editor;

import neverlang.compiler.mdl.ModuleSource;

import neverlang.runtime.Unit;
import view.MainView;

import javax.lang.model.SourceVersion;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainViewControl {

    public enum Status {
        NO_ABS_SYNTAX,
        NO_CNC_SYNTAX,
        NO_SEM_MODULE,
        NO_ROLE,
        NEED_MAPPING,
        OK
    }

    private final MainView view;

    private Configurator config;
    private Editor edit;
    private Slice slice;

    private final Comparator<ModuleSource> module_source_comparator;

    private static final String info = "Choose the abstract syntax you prefer and go on...";

    public MainViewControl(MainView view, String nl_path) throws Exception {
        try {
            this.edit = new Editor(nl_path);
        } catch (IOException e) {
            Message.showErrorAlert("Error loading neverlang files!");
            e.printStackTrace();
        }
        if(this.edit.getAbstractSyntaxes().size() < 1) {
            Message.showErrorAlert("Neverlang files not found!");
            view.close();
        }
        this.view = view;
        this.config = new Configurator();
        this.slice = new Slice("nlEditor");

        this.module_source_comparator = Comparator.comparing(Unit::getName);

    }

    public ObservableList<ModuleSource> getAbstractSyntaxes() {
        this.view.updatePreview(info);
        return FXCollections.observableArrayList(this.edit.getAbstractSyntaxes().values())
                .sorted(this.module_source_comparator);
    }

    public ObservableList<ModuleSource> getConcreteSyntaxesFromAbstractSyntax(ModuleSource module) {
        this.config.setAbstractSyntax(module);

        this.view.updatePreview(PrettyFormat.getSyntax(module));

        return FXCollections.observableArrayList(this.edit.getSyntaxesFrom(module).values())
                .sorted(this.module_source_comparator);
    }

    public ObservableList<ModuleSource> getSemanticFromSyntax(ModuleSource module) {
        this.config.setConcreteSyntax(module);
        this.slice.addSyntaxModule(this.config.getConcreteSyntax().getCanonicalName());

        this.view.updatePreview(PrettyFormat.getSyntax(module));

        return FXCollections.observableArrayList(this.edit.getSemanticFrom(module).values())
                .sorted(this.module_source_comparator);
    }

    public ObservableList<String> getRoles(ModuleSource module){
        try {
            this.config.setSemanticModule(module);
            this.view.updatePreview(PrettyFormat.getPlainSourceCode(module));
            this.view.disableAbstractAndConcreteListView(true);
            return FXCollections.observableArrayList(module.getRoles());
        } catch (IOException e){ e.printStackTrace(); }

        return null;
    }

    public void setRole(String role)
    {
        this.config.setRole(role);
    }

    public Status canAddToSlice() {
        if(this.config.getAbstractSyntax() == null)
        {
            Message.showErrorAlert("Choose an abstract syntax first!");
            return Status.NO_ABS_SYNTAX;
        }
        if(this.config.getConcreteSyntax() == null)
        {
            Message.showErrorAlert("Choose a concrete syntax first!");
            return Status.NO_CNC_SYNTAX;
        }
        if(this.config.getSemanticModule() == null)
        {
            Message.showErrorAlert("Choose a semantic module first!");
            return Status.NO_SEM_MODULE;
        }
        if(this.config.getRole() == null)
        {
            Message.showErrorAlert("Choose a role first!");
            return Status.NO_ROLE;
        }

        if( !isMappingOptional(this.config.getSemanticModule(), this.config.getConcreteSyntax())){
            Message.showErrorAlert("you need mapping");
            return Status.NEED_MAPPING;
        }

        return Status.OK;
    }

    public static boolean isMappingOptional(ModuleSource ms1, ModuleSource ms2){
        return ProductionDescriptor.isMappingOptional(ms1, ms2);
    }

    public String getCurrentModuleSourceCode() {
        if(this.config.getLastSetModule() != null)
            try {
                return PrettyFormat.getPlainSourceCode(this.config.getLastSetModule());
            } catch (IOException e) {
                e.printStackTrace();
                Message.showErrorAlert("File not found!");
                return "File not found";
            }
        Message.showErrorAlert("Select a module first!");
        return "Select a Module first!";
    }

    public String getHTMLfromModule(){
        //todo
        if(this.config.getLastSetModule() != null)
            try {
                return PrettyFormat.getHTMLFromModule(this.config.getLastSetModule());
            } catch (IOException e) {
                e.printStackTrace();
                Message.showErrorAlert("File not found!");
                return "file not found";
            }
        Message.showErrorAlert("Select a module first!");
        return "select a module first!";
    }

    public Configurator getConfig() {
        return config;
    }

    //////// RESET METHODS

    public void resetUI(){
        this.view.disableAbstractAndConcreteListView(false);
        this.view.resetListView();
    }

    public void resetButSlice(){
        this.resetUI();
        this.config.reset();
    }

    public void reset(){
        this.resetButSlice();
        this.slice = new Slice("default");
    }

    ////////

    public void addToSliceWithoutMapping(){
        if(this.slice.addSemantic(this.config.getSemanticModule().getCanonicalName(), this.config.getRole()))
            Message.showInfoAlert("Semantic Action added to slice!");
        else
            Message.showErrorAlert("Cannot add Semantic Action to slice!");
    }

    public void addMappingToSlice(String mapping){
        if(this.slice.addSemantic(this.config.getSemanticModule().getCanonicalName(), this.config.getRole(), mapping))
            Message.showInfoAlert("Semantic Action added to slice!");
        else
            Message.showErrorAlert("Cannot add Semantic Action to slice!");
    }

    public void saveSlice(){
        if(this.slice.isValid())
            this.view.showSliceSaveChooser();
        else
            Message.showErrorAlert("Slice not valid!");
    }

    public void writeOnFile(File file){
        assert file != null;

        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(this.slice.getSource());
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    //SLICE EDITOR

    public boolean canShowSliceEditor(){
        return this.slice.isValid();
    }

    public ArrayList<Pair<Slice.Entry,String>> getSliceElements(){
        return this.slice.getElements();
    }

    private boolean checkSliceName(String name) {
        //todo add further checks

        String [] tmp = name.split("\\.");

        for(String s : tmp)
            if(!SourceVersion.isIdentifier(s)) return false;

        return true;
        //return name != null;
    }

    public void changeSliceName(String name) {
        if(!this.checkSliceName(name))
            Message.showErrorAlert("Invalid Name");
        else {
            this.slice.addSliceName(name);
            this.view.updateSliceEditor();
        }
    }

    public void removeSyntaxFromSlice(){

        if(!Message.showBoolAlert("Do You want delete this syntax?")) return;

        if( this.slice.removeSyntax() )
            this.view.updateSliceEditor();

        this.resetButSlice();
    }

    public void removeSemanticFromSlice(int group){
        if(!Message.showBoolAlert("Do You want delete this semantic?")) return;

        if(this.slice.removeSemanticModule(group))
            this.view.updateSliceEditor();
    }

    public void removeRoleFromSlice(int group){
        System.out.println("debug role");
        if(!Message.showBoolAlert("Do You want delete this role?")) return;

        if(this.slice.removeSemanticModule(group))
            this.view.updateSliceEditor();
    }

    public void removeMappingFromSlice(int group){

        //todo add control if no mapping need
        //so remove only the mapping and not also the module
        //
        //idea change slice class -> arraylist of modulsource for semantic and syntax
        //easier to retreive module to make the check for the mapping
        // ProdDesc.isMappinOptional(ms1. ms2)

        if(!Message.showBoolAlert("Do You want delete this mapping?")) return;
        System.out.println("debug");
        if(this.slice.removeMapping(group))
            this.view.updateSliceEditor();
    }

}
