package util;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.Optional;

public class Message {

    public static void showInfoAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setTitle("");
        alert.setHeaderText(message);
        alert.setContentText("");
        closeAfter(alert, 3);
        alert.showAndWait();
    }

    public static String showTextInput(String message){
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("");
        dialog.setHeaderText("");
        dialog.setContentText(message+":");

        return dialog.showAndWait().orElse(null);
    }

    public static void showErrorAlert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setTitle("");
        alert.setHeaderText(message);
        alert.setContentText("");
        closeAfter(alert, 3);
        alert.showAndWait();
    }

    public static boolean showBoolAlert(String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setTitle("");
        alert.setHeaderText(message);
        alert.setContentText("");
        return alert.showAndWait().get() == ButtonType.OK;
    }

    private static void closeAfter(Alert alert, int seconds){
        PauseTransition delay = new PauseTransition(Duration.seconds(seconds));
        delay.setOnFinished( event -> alert.close() );
        delay.play();
    }

}
