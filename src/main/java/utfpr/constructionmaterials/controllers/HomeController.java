package utfpr.constructionmaterials.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import utfpr.constructionmaterials.client.services.clientMessageService.ClientMessageHelper;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.connection.CloseConnectionDTO;
import utfpr.constructionmaterials.replyEvents.errors.CloseConnectionErrorDTO;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;
import utfpr.constructionmaterials.shared.singletons.CurrentUser;

import java.net.URL;
import java.util.ResourceBundle;

import static utfpr.constructionmaterials.shared.constants.ClientConfigs.WELCOME_TEXT;
import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.*;
import static utfpr.constructionmaterials.shared.constants.SuccessMessages.LOGOUT_SUCCESS;

public class HomeController implements Initializable {
    @FXML
    private Pane homePane;
    @FXML
    private Button logout;
    @FXML
    private Label welcomeLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeLabel.setText(WELCOME_TEXT + " " + CurrentUser.getInstance().getUser().getName());
    }

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
        FXMLHelper.navigateTo(REGISTER, homePane);
    }

    @FXML
    public void transactionsList(ActionEvent actionEvent) {
        FXMLHelper.navigateTo(TRANSACTIONS_LIST, homePane);
    }

    @FXML
    public void showServerView(ActionEvent actionEvent) {
        FXMLHelper.navigateTo(SERVER_VIEW, homePane);
    }
}
