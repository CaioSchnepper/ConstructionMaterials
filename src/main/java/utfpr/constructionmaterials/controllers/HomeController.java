package utfpr.constructionmaterials.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import utfpr.constructionmaterials.client.services.clientMessageService.ClientMessageHelper;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.connection.CloseConnectionDTO;
import utfpr.constructionmaterials.replyEvents.errors.CloseConnectionErrorDTO;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;
import utfpr.constructionmaterials.shared.singletons.CurrentUser;

import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.*;
import static utfpr.constructionmaterials.shared.constants.SuccessMessages.LOGOUT_SUCCESS;

public class HomeController {
    @FXML
    private Pane homePane;
    @FXML
    private Button logout;

    @FXML
    public void logoutUser(ActionEvent actionEvent) {
        CloseConnectionDTO closeDTO = new CloseConnectionDTO();
        EventDTO result = ClientMessageHelper.send(closeDTO);

        if (result instanceof CloseConnectionErrorDTO) {
            FXMLHelper.showErrorAlert(((CloseConnectionErrorDTO) result).getClose().getError(), homePane);
        } else {
            CurrentUser.destroyInstance();
            FXMLHelper.showSuccessAlert(LOGOUT_SUCCESS, homePane);
            FXMLHelper.navigateTo(LOGIN, homePane);
        }
    }

    @FXML
    public void receive(ActionEvent actionEvent) {
        FXMLHelper.navigateTo(RECEPTIONS_LIST, homePane);
    }

    @FXML
    public void donationRegister(ActionEvent actionEvent) {
        FXMLHelper.navigateTo(DONATION_REGISTER, homePane);
    }

    @FXML
    public void updateUser(ActionEvent actionEvent) {
    }

    @FXML
    public void transactionsList(ActionEvent actionEvent) {
        FXMLHelper.navigateTo(TRANSACTIONS_LIST, homePane);
    }
}
