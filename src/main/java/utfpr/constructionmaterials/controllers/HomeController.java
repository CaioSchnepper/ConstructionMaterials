package utfpr.constructionmaterials.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;

import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.LOGIN;

public class HomeController {
    @FXML
    private Button logout;
    @FXML
    private Pane homePane;

    @FXML
    public void navigateToLogin() {
        Parent loginPane = FXMLHelper.load(LOGIN);
        homePane.getChildren().clear();
        homePane.getScene().setRoot(loginPane);
    }
}
