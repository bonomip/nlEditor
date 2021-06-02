package view.cell.mapping;

import control.MappingViewControl;
import javafx.scene.control.Label;
import model.ProductionDescriptor;

public class MappingSemanticCellView extends MappingCellView {

    public MappingSemanticCellView(MappingViewControl ctrl, ProductionDescriptor p) {
        super(ctrl, p);
        super.highLightStyle = "-fx-background-color: red";
    }

    @Override
    public void addNonTerminal(String s, int idx) {
        super.addNonTerminal(s, event -> ctrl.onSemanticNonTerminalClicked(production, idx), false);
    }

    @Override
    public void reset() {
        super.resetLabelsActionStyle();
        for(Label l : super.nt_labels) l.setDisable(true);
    }

    @Override
    public void lightUpLabels(int[] idx) {
        super.lightUpLabels(idx);
        super.disable(false, idx);
    }
}
