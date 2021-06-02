package view;

import control.MainViewControl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.web.WebView;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import control.MainViewControl.Status;
import javafx.util.Pair;
import model.Slice;
import neverlang.compiler.mdl.ModuleSource;
import util.Message;
import view.cell.factory.module.ModuleSourceCellFactory;

import java.io.File;
import java.util.ArrayList;

public class MainView extends Application {

    private MainViewControl ctrl;
    private Stage stage, slice_stage;

    @Override
    public void start(Stage stage) throws Exception {
        //launch the
        this.stage = stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main_window.fxml"));
        stage.setTitle("nlEditor");
        stage.setScene(new Scene(root, 1200, 800));
        stage.show();
    }

    public static void showView(String name){launch(name);}

    /* --------  EVENT LISTENER ETC. ------ */

    @FXML
    private ListView<ModuleSource> lv_abs_syntax;
    @FXML
    private ListView<ModuleSource> lv_syntax;
    @FXML
    private ListView<ModuleSource> lv_semantic;
    @FXML
    private ListView<String> lv_roles;
    @FXML
    private TextArea t_preview;

    public void close(){
        this.stage.close();
    }

    public void initialize() throws Exception {
        //link this view with the Control class

        String path = new DirectoryChooser().showDialog(this.stage).getAbsolutePath();
        this.ctrl = new MainViewControl(this, path);

        //populate the abstract syntax list view
        this.lv_abs_syntax.setItems(this.ctrl.getAbstractSyntaxes());

        //cell factory settings
        this.lv_abs_syntax.setCellFactory(param -> new ModuleSourceCellFactory());
        this.lv_syntax.setCellFactory(param -> new ModuleSourceCellFactory());
        this.lv_semantic.setCellFactory(param -> new ModuleSourceCellFactory());
    }

    public void updatePreview(String content) {
        this.t_preview.clear();
        this.t_preview.setText(content);
    }

    @FXML
    void onAbstractSyntaxSelection(MouseEvent event) {
        this.lv_syntax.setItems(
                this.ctrl.getConcreteSyntaxesFromAbstractSyntax(
                    this.lv_abs_syntax
                            .getSelectionModel()
                            .getSelectedItem()
                )
        );
    }

    @FXML
    void onSyntaxSelection(MouseEvent event) {
        this.lv_semantic.setItems(
                this.ctrl.getSemanticFromSyntax(
                        this.lv_syntax
                                .getSelectionModel()
                                .getSelectedItem()
                )
        );
    }

    @FXML
    void onSemanticSelection(MouseEvent event) {
        this.lv_roles.setItems(
                this.ctrl.getRoles(
                        this.lv_semantic
                                .getSelectionModel()
                                .getSelectedItem()
                )
        );
    }

    @FXML
    void onRoleSelection(MouseEvent event) {
        this.ctrl.setRole(this.lv_roles.getSelectionModel().getSelectedItem());
    }

    @FXML
    void onAddWithoutMapping(ActionEvent event) {
        if(this.ctrl.canAddToSlice() == Status.OK){
            this.ctrl.addToSliceWithoutMapping();
        }
    }

    @FXML
    void onAddWithMapping(ActionEvent event){
        //todo prevent duplicate views
        if(this.ctrl.canAddToSlice() == Status.OK || this.ctrl.canAddToSlice() == Status.NEED_MAPPING) {
            MappingView mv = new MappingView();
            mv.showView(this.stage, this.ctrl);
        }
    }

    @FXML
    void onSrcCodeView(ActionEvent event) {
        //open pop up and show source code of selected list view item
        final Stage dialog = new Stage();
        dialog.initModality(Modality.NONE);
        dialog.initOwner(this.stage);
        VBox dialogVbox = new VBox(20);
        WebView wv = new WebView();
        wv.getEngine().loadContent(this.ctrl.getHTMLfromModule());
        dialogVbox.getChildren().add(wv);
        Scene dialogScene = new Scene(dialogVbox, 800, 500);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    @FXML
    void onRevert(){
        this.ctrl.reset();
    }

    @FXML
    public void onSave(){
        this.ctrl.saveSlice();
    }

    public void disableAbstractAndConcreteListView(boolean b){
        this.lv_abs_syntax.setMouseTransparent(b);
        this.lv_abs_syntax.setFocusTraversable(!b);
        this.lv_syntax.setMouseTransparent(b);
        this.lv_syntax.setFocusTraversable(!b);
    }

    public void resetListView(){
        this.lv_syntax.setItems(FXCollections.observableArrayList(new ArrayList<>()));
        this.lv_semantic.setItems(FXCollections.observableArrayList(new ArrayList<>()));
        this.lv_roles.setItems(FXCollections.observableArrayList(new ArrayList<>()));
    }



    public void showSliceSaveChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Neverlang", "*.nl"));
        File file = fileChooser.showSaveDialog(stage);
        this.ctrl.writeOnFile(file);
    }

    //
    //
    //SLICE EDITOR
    //
    //

    private TextFlow slice_editor;

    private void addSliceEntriesToTextFlow(ObservableList<Node> textFlow, ArrayList<Pair<Slice.Entry,String>> elem ){
        int group = 0;
        for(Pair<Slice.Entry, String> p : elem){
            switch (p.getKey()){
                case OTHER:
                    textFlow.add(new Text(p.getValue()));
                    break;
                case NAME:
                    Hyperlink name = new Hyperlink(p.getValue());
                    name.setOnMouseClicked(event -> onSliceNameClicked());
                    textFlow.add(name);
                    break;
                case SYNTAX:
                    Text syntax = new Text(p.getValue());
                    syntax.setOnMouseClicked(e -> onSliceSyntaxClicked());
                    syntax.setFill(Color.RED);
                    textFlow.add(syntax);
                    break;
                case SEMANTIC:
                    group++;
                    Text semantic = new Text(p.getValue());
                    int finalGroup = group-1;
                    semantic.setOnMouseClicked(e -> onSliceSemanticClicked(finalGroup));
                    semantic.setFill(Color.RED);
                    textFlow.add(semantic);
                    break;
                case ROLE:
                    Text role = new Text(p.getValue());
                    int finalGroup1 = group-1;
                    role.setOnMouseClicked(e -> onSliceRoleClicked(finalGroup1));
                    role.setFill(Color.RED);
                    textFlow.add(role);
                    break;
                case MAPPING:
                    Text mapping = new Text(p.getValue());
                    int finalGroup2 = group-1;
                    mapping.setOnMouseClicked(e -> onSliceMappingClicked(finalGroup2));
                    mapping.setFill(Color.BLUE);
                    textFlow.add(mapping);
                    break;
                default:
                    System.out.println("MainView - addSliceEntriesToTextFlow => Error!");
            }
        }
    }

    public void onEditSlice(ActionEvent actionEvent) {

        //todo this might be redundant
        if(this.ctrl.canShowSliceEditor()){
            if(this.slice_stage != null && this.slice_stage.isShowing())
                this.slice_stage.close();

            this.slice_editor = new TextFlow();

            this.addSliceEntriesToTextFlow(slice_editor.getChildren(), this.ctrl.getSliceElements());

            VBox vBox = new VBox(slice_editor);
            Scene scene = new Scene(vBox, 800, 300);
            this.slice_stage = new Stage();
            this.slice_stage.setScene(scene);
            this.slice_stage.initModality(Modality.APPLICATION_MODAL);
            this.slice_stage.initOwner(this.stage);
            this.slice_stage.showAndWait();

        } else {
            Message.showErrorAlert("Cannot show slice editor!");
        }
    }

    private void onSliceNameClicked(){
        String user = Message.showTextInput("Enter Slice Name");
        this.ctrl.changeSliceName(user);
    }

    private void onSliceSyntaxClicked(){
        this.ctrl.removeSyntaxFromSlice();
    }

    private void onSliceSemanticClicked(int group){
        this.ctrl.removeSemanticFromSlice(group);
    }

    private void onSliceRoleClicked(int group){
        this.ctrl.removeRoleFromSlice(group);
    }

    private void onSliceMappingClicked(int group){
        this.ctrl.removeMappingFromSlice(group);
    }

    public void updateSliceEditor(){
        this.slice_editor.getChildren().clear();
        addSliceEntriesToTextFlow(this.slice_editor.getChildren(), this.ctrl.getSliceElements());
    }
}
