package utfpr.constructionmaterials.shared.helpers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utfpr.constructionmaterials.shared.singletons.CurrentIcon;

import java.io.IOException;
import java.util.Objects;

import static utfpr.constructionmaterials.shared.constants.ClientConfigs.EMPTY;
import static utfpr.constructionmaterials.shared.constants.ClientConfigs.ERROR;
import static utfpr.constructionmaterials.shared.constants.ErrorMessages.LOAD_FXML_ERROR;

public class FXMLHelper {

    public static void navigateTo(String newLocation, Pane oldLocation) {
        Parent newPane = load(newLocation);
        oldLocation.getChildren().clear();
        oldLocation.getScene().setRoot(newPane);
    }

    public static Parent load(String fileName) {
        try {
            return FXMLLoader.load(Objects.requireNonNull(FXMLHelper.class.getResource("/" + fileName)));
        } catch (IOException ex) {
            throw new RuntimeException(LOAD_FXML_ERROR, ex);
        }
    }

    public static void showErrorAlert(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        applyAlertStyle(alert);
        alert.setTitle(ERROR);
        alert.setHeaderText(errorMessage);
        alert.showAndWait();
    }

    public static void showSuccessAlert(String successMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        applyAlertStyle(alert);
        alert.setTitle(EMPTY);
        alert.setHeaderText(successMessage);
        alert.showAndWait();
    }

    private static void applyAlertStyle(Alert alert) {
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(CurrentIcon.getInstance().getIcon());

        alert.setResizable(true);
        alert.getDialogPane().setPrefSize(300, 150);

        ButtonBar buttonBar = (ButtonBar)alert.getDialogPane().lookup(".button-bar");
        buttonBar.getButtons().forEach(button -> button.setStyle("-fx-background-color: #2196f3;"));
    }

}
