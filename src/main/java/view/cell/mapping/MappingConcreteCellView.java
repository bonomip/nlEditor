package view.cell.mapping;

import control.MappingViewControl;
import javafx.scene.control.Label;
import model.ProductionDescriptor;

public class MappingConcreteCellView extends MappingCellView{



    public MappingConcreteCellView(MappingViewControl ctrl, ProductionDescriptor p) {
        super(ctrl, p);
        this.highLightStyle = "-fx-background-color: blue";
    }

    @Override
    public void addNonTerminal(String s, int idx) {
        super.addNonTerminal(s, event -> ctrl.onConcreteNonTerminalClicked(production,idx), true);
    }

    @Override
    public void reset() {
        super.resetLabelsActionStyle();
        for(Label l : super.nt_labels) l.setDisable(false);
    }

    @Override
    public void lightUpLabels(int[] idx) {
        super.lightUpLabels(idx);
    }


}
