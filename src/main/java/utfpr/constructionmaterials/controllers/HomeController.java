package utfpr.constructionmaterials.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import utfpr.constructionmaterials.client.services.clientMessageService.ClientMessageHelper;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.connection.CloseConnectionDTO;
import utfpr.constructionmaterials.replyEvents.errors.CloseConnectionErrorDTO;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;
import utfpr.constructionmaterials.shared.singletons.CurrentUser;

import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.LOGIN;
import static utfpr.constructionmaterials.shared.constants.SuccessMessages.LOGOUT_SUCCESS;

public class HomeController {
    @FXML
    private Button logout;
    @FXML
    private Pane homePane;

    @FXML
    public void logoutUser() {
        User currentUser = CurrentUser.getInstance().getUser(); // Exemplo de como buscar o usuário logado

        CloseConnectionDTO closeDTO = new CloseConnectionDTO();
        EventDTO result = ClientMessageHelper.send(closeDTO);

        if (result instanceof CloseConnectionErrorDTO) {
            FXMLHelper.showErrorAlert(((CloseConnectionErrorDTO) result).getClose().getError(), homePane);
        } else {
            CurrentUser.destroyInstance();
            FXMLHelper.showSuccessAlert(LOGOUT_SUCCESS, homePane);
            navigateToLogin();
        }
    }

    private void navigateToLogin() {
        Parent loginPane = FXMLHelper.load(LOGIN);
        homePane.getChildren().clear();
        homePane.getScene().setRoot(loginPane);
    }

}
