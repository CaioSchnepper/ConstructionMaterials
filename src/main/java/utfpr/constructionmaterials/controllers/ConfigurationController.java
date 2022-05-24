package utfpr.constructionmaterials.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.springframework.boot.SpringApplication;
import utfpr.constructionmaterials.client.ClientApplication;
import utfpr.constructionmaterials.shared.constants.ErrorMessages;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;

import java.util.Properties;

import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.LOGIN;
import static utfpr.constructionmaterials.shared.constants.SuccessMessages.CONFIGURATION_SUCCESS;

public class ConfigurationController {

    @javafx.fxml.FXML
    private TextField serverIp;
    @javafx.fxml.FXML
    private TextField serverPort;
    @javafx.fxml.FXML
    private Pane configurationPane;

    @javafx.fxml.FXML
    public void enterServer(ActionEvent actionEvent) {

        if (configIsInvalid()) {
            FXMLHelper.showErrorAlert(ErrorMessages.MISSING_FIELDS, configurationPane);
            return;
        }

        SpringApplication clientApplication = new SpringApplication(ClientApplication.class);
        clientApplication.setDefaultProperties(getServerProperties());
        clientApplication.run();

        FXMLHelper.showSuccessAlert(CONFIGURATION_SUCCESS, configurationPane);
        navigateToLogin();
    }

    @javafx.fxml.FXML
    public void applicationExit(ActionEvent actionEvent) {
        //TODO
    }

    public void navigateToLogin() {
        Parent loginPane = FXMLHelper.load(LOGIN);
        configurationPane.getChildren().clear();
        configurationPane.getScene().setRoot(loginPane);
    }

    private boolean configIsInvalid() {
        return serverIp.getText().isEmpty() || serverPort.getText().isEmpty();
    }

    private Properties getServerProperties() {
        Properties properties = new Properties();
        properties.put("tcp.server.host", serverIp);
        properties.put("tcp.server.port", serverPort);
        return properties;
    }

}
