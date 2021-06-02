package view.cell.mapping;

import control.MappingViewControl;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import model.ProductionDescriptor;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class MappingCellView {

    protected HBox content;
    protected MappingViewControl ctrl;
    protected ProductionDescriptor production;
    protected final ArrayList<Label> nt_labels = new ArrayList<>();

    protected String highLightStyle;

    protected ArrayList<String> actionStyles = new ArrayList<>();
    protected String pairedStyleForm = "-fx-background-color: ";
    protected String baseStyle = "-fx-border-color: blue;";


    private static String[] COLORS = {
            "seagreen",
            "powderblue",
            "plum",
            "yellow",
            "salmon",
            "olive",
            "moccasin",
            "gold",
            "darkorchid",
            "lightseagreen"
    };

    private static ArrayList<String> USED_PAIRED_COLORS = new ArrayList<>(Arrays.asList(COLORS));


    /*
     *    mind that we are only adding view to the list controlled by ctrl
     *    we never remove them. this because the item in the list are fixed
     */
    public MappingCellView(MappingViewControl ctrl, ProductionDescriptor p) {
        this.ctrl = ctrl;
        this.production = p;
        this.content = new HBox();
    }

    public abstract void addNonTerminal(String s, int idx);

    protected void addNonTerminal(String s, EventHandler<MouseEvent> handler, boolean active) {
        Label l = new Label(" "+s.toString()+" ");
        l.setStyle(baseStyle);
        l.setOnMouseClicked(handler);
        l.setDisable(!active);
        this.nt_labels.add(l);
        this.actionStyles.add(baseStyle);
        this.content.getChildren().add(l);
    }

    public void addProductionArrow() {
        Label l = new Label(" <-- ");
        this.content.getChildren().add(l);
    }

    public void addTerminal(String terminal) {
        this.content.getChildren().add(new Label(" "+terminal+" "));
    }

    public abstract void reset();

    public void resetLabelsActionStyle() {
        for(Label l : this.nt_labels)
            l.setStyle(this.actionStyles.get(this.nt_labels.indexOf(l)));
    }

    public void lightUpLabels(int[] idx) {
        for (int j : idx) this.nt_labels.get(j).setStyle(highLightStyle);
    }

    public static void resetPairedColors(){
            USED_PAIRED_COLORS.clear();
            USED_PAIRED_COLORS.addAll(Arrays.asList(COLORS));
    }

    public static String genPairedColor(){
        if(USED_PAIRED_COLORS.size() == 0) return "black";
        return USED_PAIRED_COLORS.remove(0);
    }

    public void setNtPairedColor(String javaFxColors, int nt_id){
        this.actionStyles.set(nt_id, pairedStyleForm+javaFxColors+";");
    }

    public void resetAllActionColors (){
        this.actionStyles.replaceAll(e -> baseStyle);
    }

    public MappingCellView setContent() {
        this.content.setSpacing(10);
        return this;
    }

    public HBox getContent() {
        return content;
    }

    public ProductionDescriptor getProductionDescriptor()
    {
        return this.production;
    }

    public void disable(boolean b, int[] idx) {
        for (int j : idx) this.nt_labels.get(j).setDisable(b);
    }
}
