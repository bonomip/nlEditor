package view.cell.factory.mapping;

import javafx.scene.control.ListCell;
import view.cell.mapping.MappingConcreteCellView;

public class MappingConcreteCellFactory extends ListCell<MappingConcreteCellView> {

    @Override
    protected void updateItem(MappingConcreteCellView item, boolean empty) {
        super.updateItem(item, empty);

        if(empty || item == null) {
            setText(null);
            setGraphic(null);
        }
        else {
            setGraphic(item.getContent());
        }
    }
}
