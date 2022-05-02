package utfpr.constructionmaterials.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;
import utfpr.constructionmaterials.shared.singletons.CurrentUser;

import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.LOGIN;

public class HomeController {
    @FXML
    private Button logout;
    @FXML
    private Pane homePane;

    @FXML
    public void navigateToLogin() {
        User currentUser = CurrentUser.getInstance().getUser(); // Exemplo de como buscar o usuário logado

        Parent loginPane = FXMLHelper.load(LOGIN);
        homePane.getChildren().clear();
        homePane.getScene().setRoot(loginPane);
    }
}
