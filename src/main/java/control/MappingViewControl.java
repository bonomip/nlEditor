package control;


import dexter.grammar.NonTerminalSym;
import dexter.grammar.Symbol;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Pair;
import model.Mapper;
import model.ProductionDescriptor;
import util.Message;
import view.cell.mapping.MappingCellView;
import view.cell.mapping.MappingConcreteCellView;
import view.cell.mapping.MappingSemanticCellView;
import view.MappingView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MappingViewControl {

    private final MainViewControl ctrl;
    private final Configurator config;
    private final MappingView view;

    private ArrayList<MappingConcreteCellView> concrete_cell_views;
    private ArrayList<MappingSemanticCellView> semantic_cell_views;
    private final Mapper mapper;

    public MappingViewControl(MainViewControl ctrl, MappingView view) {
        this.ctrl = ctrl;
        this.config = this.ctrl.getConfig();
        this.view = view;

        this.mapper = new Mapper(
                this.config.getConcreteSyntax(),
                this.config.getSemanticModule(),
                this.config.getRole());
    }

    public String getViewTitle() {
        return this.config.getConcreteSyntax().getName()+" "
                +this.config.getSemanticModule().getName()+" "
                +this.config.getRole();
    }

    //LIST VIEW METHODS

    public ObservableList<MappingConcreteCellView> getConcreteListItems() {
        this.concrete_cell_views = this.getConcreteCellViewsFrom(this.mapper.getConcreteProductionDescriptors());
        return FXCollections.observableArrayList(this.concrete_cell_views);
    }

    private ArrayList<MappingConcreteCellView> getConcreteCellViewsFrom(ArrayList<ProductionDescriptor> list) {
        return (ArrayList<MappingConcreteCellView>) list
                .stream()
                .map(p -> (MappingConcreteCellView) setUpCellView(new MappingConcreteCellView(this, p), p.getTokenizedProduction()))
                .collect(Collectors.toList());
    }

    public ObservableList<MappingSemanticCellView> getSemanticListItems() {
        this.semantic_cell_views = this.getSemanticCellViewsFrom(this.mapper.getSemanticProductionDescriptors());
        return FXCollections.observableArrayList(this.semantic_cell_views);
    }

    private ArrayList<MappingSemanticCellView> getSemanticCellViewsFrom(ArrayList<ProductionDescriptor> list) {
        return (ArrayList<MappingSemanticCellView>) list
                .stream()
                .map(p -> (MappingSemanticCellView) setUpCellView(new MappingSemanticCellView(this, p), p.getTokenizedProduction()))
                .collect(Collectors.toList());
    }

    private MappingCellView setUpCellView(MappingCellView view, LinkedList<Symbol> symbols) {

        int count = 0;

        view.addNonTerminal(symbols.removeFirst().toString(), count++);
        view.addProductionArrow();

        while(!symbols.isEmpty()) {
            Symbol sym = symbols.removeFirst();
            if(sym instanceof NonTerminalSym)
                view.addNonTerminal(sym.toString(), count++);
            else
                view.addTerminal(sym.toString());
        }

        return view.setContent();
    }

    public void onConcreteNonTerminalClicked(ProductionDescriptor p, int nt_idx) {
        if(this.mapper.isNtAvailable(p, nt_idx)) {
            //reset all the semantic nts
            this.resetLabelsColorAndStatus(new ArrayList<>(this.semantic_cell_views));
            //reset all concrete nts color
            this.resetLabelsColor(new ArrayList<>(this.concrete_cell_views));

            //high light the selected concrete nts
            this.highLightConcreteLabel(p, nt_idx);
            //high light valid concrete nts
            this.highLightSemanticLabes(this.mapper.getValidNonTerminalsFrom(p, nt_idx));

            this.config.setConcreteProductionAndNtId(p, nt_idx);
        } else {
            System.out.println("nt is already mapped");
        }
    }

    public void onSemanticNonTerminalClicked(ProductionDescriptor p, int nt_idx) {
        this.mapper.swap(this.config.getConcreteProduction(), this.config.getConcreteProductionNt(), p, nt_idx);
        this.setNewPairedColor(this.config.getConcreteProduction(), this.config.getConcreteProductionNt(), p, nt_idx);
        this.resetLabelsColorAndStatus(new ArrayList<>(this.semantic_cell_views));
        this.resetLabelsColor(new ArrayList<>(this.concrete_cell_views));
    }

    //MENU ITEM RESPONSE

    public void applyMapping(){
        if(this.mapper.getSwapsNumber() < 1) {
            Message.showInfoAlert("No changes has been made!");
            return;
        }

        if(compareSwapsAndNt()) {
            this.ctrl.addMappingToSlice(this.mapper.getString());
            MappingCellView.resetPairedColors();
            Message.showInfoAlert("Mapping added correctly");
            this.view.quit();
        } else Message.showErrorAlert("Incomplete Mapping!");
    }

    private boolean compareSwapsAndNt(){
        int i = 0;
        for(ProductionDescriptor p : this.mapper.getConcreteProductionDescriptors())
            i += p.getNtCount();

        return this.mapper.getSwapsNumber() == i;
    }

    public void resetMapping() {
        MappingCellView.resetPairedColors();

        this.resetLabelsActionColor(
                Stream.concat(this.concrete_cell_views.stream(), this.semantic_cell_views.stream())
                        .collect(Collectors.toList())
        );
        this.resetLabelsColorAndStatus(
                Stream.concat(this.concrete_cell_views.stream(), this.semantic_cell_views.stream())
                        .collect(Collectors.toList())
        );

        this.mapper.reset();
        this.config.resetMappingValues();
    }

    //PRIVATE METHODS

    private void highLightSemanticLabes(ArrayList<Pair<ProductionDescriptor, int[]>> list) {
        for(MappingCellView view : this.semantic_cell_views)
            for(Pair<ProductionDescriptor, int[]> item2 : list)
                if(view.getProductionDescriptor().equals(item2.getKey()))
                    view.lightUpLabels(item2.getValue());
    }

    private void highLightConcreteLabel(ProductionDescriptor p, int id) {
        for(MappingCellView view : this.concrete_cell_views)
            if(view.getProductionDescriptor().equals(p)) {
                view.lightUpLabels(new int[]{id});
                view.disable(true, new int[]{id});
            }
    }

    private void resetLabelsColorAndStatus(List<MappingCellView> list) {
        for(MappingCellView view : list)
            view.reset();
    }

    private void resetLabelsColor(List<MappingCellView> list) {
        for(MappingCellView view : list)
            view.resetLabelsActionStyle();
    }

    private void resetLabelsActionColor(List<MappingCellView> list){
        for(MappingCellView view : list)
            view.resetAllActionColors();
    }

    private void setNewPairedColor(ProductionDescriptor concrete_prod, int concrete_nt_id, ProductionDescriptor semantic_prod, int semantic_nt_id){

        String color = MappingCellView.genPairedColor();

        for(MappingCellView view : Stream
                .concat(this.concrete_cell_views.stream(), this.semantic_cell_views.stream())
                .collect(Collectors.toList()) )

            if(view.getProductionDescriptor().equals(concrete_prod) )
                view.setNtPairedColor(color, concrete_nt_id );
            else if (view.getProductionDescriptor().equals(semantic_prod))
                view.setNtPairedColor(color, semantic_nt_id);
    }
}
