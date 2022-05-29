package utfpr.constructionmaterials.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utfpr.constructionmaterials.client.services.clientApplicationService.ClientApplicationService;
import utfpr.constructionmaterials.shared.constants.ErrorMessages;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;

import java.net.URL;
import java.util.ResourceBundle;

import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.LOGIN;
import static utfpr.constructionmaterials.shared.constants.SuccessMessages.CONFIGURATION_SUCCESS;

public class ConfigurationController implements Initializable {
    @FXML
    private TextField serverIp;
    @FXML
    private TextField serverPort;
    @FXML
    private Pane configurationPane;
    @FXML
    private ProgressIndicator loadingSpinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadingSpinner.setVisible(false);
    }

    @FXML
    public void enterServer(ActionEvent actionEvent) {

        if (configIsInvalid()) {
            FXMLHelper.showErrorAlert(ErrorMessages.MISSING_FIELDS, configurationPane);
            return;
        }

        loadingSpinner.setVisible(true);

        final ClientApplicationService clientApplicationService = new ClientApplicationService(serverIp.getText(), serverPort.getText());

        clientApplicationService.setOnSucceeded(workerStateEvent -> {
            loadingSpinner.setVisible(false);
            FXMLHelper.showSuccessAlert(CONFIGURATION_SUCCESS, configurationPane);
            FXMLHelper.navigateTo(LOGIN, configurationPane);
        });

        clientApplicationService.setOnFailed(workerStateEvent -> {
            loadingSpinner.setVisible(false);
            FXMLHelper.showErrorAlert(ErrorMessages.APP_START_ERROR, configurationPane);
        });

        clientApplicationService.restart();
    }

    @FXML
    public void applicationExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    private boolean configIsInvalid() {
        return serverIp.getText().isEmpty() || serverPort.getText().isEmpty();
    }

}
