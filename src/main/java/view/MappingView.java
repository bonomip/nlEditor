package view;

import control.MainViewControl;
import control.MappingViewControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import view.cell.factory.mapping.MappingConcreteCellFactory;
import view.cell.factory.mapping.MappingSemanticCellFactory;
import view.cell.mapping.MappingConcreteCellView;
import view.cell.mapping.MappingSemanticCellView;

import java.io.IOException;

public class MappingView {

    private MappingViewControl ctrl;
    private Stage stage;

    public void showView(Stage parent, MainViewControl ctrl) {

        this.ctrl = new MappingViewControl(ctrl, this);

        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("mapping_window.fxml"));
            loader.setController(this);
            root = loader.load();
            stage = new Stage();
            stage.initOwner(parent);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(this.ctrl.getViewTitle());
            stage.setScene(new Scene(root, 1000, 450));
            stage.showAndWait();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private MenuItem m_revert;

    @FXML
    private MenuItem m_apply;

    @FXML
    private ListView<MappingConcreteCellView> lv_left_prods;

    @FXML
    private ListView<MappingSemanticCellView> lv_right_prods;

    public void initialize() {//return new MappingCell();

        // setup lists
        Callback<ListView<MappingConcreteCellView>, ListCell<MappingConcreteCellView>> concrete_cell_factory = param -> new MappingConcreteCellFactory();
        Callback<ListView<MappingSemanticCellView>, ListCell<MappingSemanticCellView>> semantic_cell_factory = param -> new MappingSemanticCellFactory();

        this.lv_left_prods.setCellFactory(concrete_cell_factory);
        this.lv_left_prods.setItems(this.ctrl.getConcreteListItems());

        this.lv_right_prods.setCellFactory(semantic_cell_factory);
        this.lv_right_prods.setItems(this.ctrl.getSemanticListItems());
    }

    @FXML
    void onApply(ActionEvent event) {
            this.ctrl.applyMapping();
    }

    @FXML
    void onLeftItemClicked(MouseEvent event) {

    }

    @FXML
    void onRevert(ActionEvent event) {
        this.ctrl.resetMapping();
    }

    @FXML
    void onRightItemClicked(MouseEvent event) {

    }

    public void quit(){
        this.stage.close();
    }

}
