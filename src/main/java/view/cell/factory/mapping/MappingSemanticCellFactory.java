package view.cell.factory.mapping;

import javafx.scene.control.ListCell;
import view.cell.mapping.MappingSemanticCellView;

public class MappingSemanticCellFactory extends ListCell<MappingSemanticCellView> {

    @Override
    protected void updateItem(MappingSemanticCellView item, boolean empty) {
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
