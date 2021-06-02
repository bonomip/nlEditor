package view.cell.factory.module;

import javafx.scene.control.ListCell;
import neverlang.compiler.mdl.ModuleSource;

public class ModuleSourceCellFactory extends ListCell<ModuleSource> {
    @Override
    protected void updateItem(ModuleSource item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null || item.getName() == null) {
            setText(null);
        } else {
            setText(item.getName());
        }
    }
}
