package utfpr.constructionmaterials.shared.helpers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;

import static utfpr.constructionmaterials.shared.constants.ErrorMessages.LOAD_FXML_ERROR;

public class FXMLHelper {

    public static void navigateTo(String newLocation, Pane oldLocation) {
        Parent newPane = load(newLocation);
        oldLocation.getChildren().clear();
        oldLocation.getScene().setRoot(newPane);
    }

    public static Parent load(String fileName){
        try {
            return FXMLLoader.load(Objects.requireNonNull(FXMLHelper.class.getResource("/" + fileName)));
        } catch (IOException ex) {
            throw new RuntimeException(LOAD_FXML_ERROR, ex);
        }
    }

    public static void showErrorAlert(String errorMessage, Pane pane) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(errorMessage);
        alert.setWidth(pane.getWidth());
        alert.showAndWait();
    }

    public static void showSuccessAlert(String successMessage, Pane pane) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(successMessage);
        alert.setWidth(pane.getWidth());
        alert.showAndWait();
    }

}
