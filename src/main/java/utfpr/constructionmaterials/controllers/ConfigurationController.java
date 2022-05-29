package utfpr.constructionmaterials.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.springframework.boot.SpringApplication;
import utfpr.constructionmaterials.client.ClientApplication;
import utfpr.constructionmaterials.shared.constants.ErrorMessages;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;

import java.net.URL;
import java.util.Properties;
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

        loadingSpinner.setVisible(true);

        if (configIsInvalid()) {
            FXMLHelper.showErrorAlert(ErrorMessages.MISSING_FIELDS, configurationPane);
            loadingSpinner.setVisible(false);
            return;
        }

        SpringApplication clientApplication = new SpringApplication(ClientApplication.class);
        clientApplication.setDefaultProperties(getServerProperties());
        clientApplication.run();

        loadingSpinner.setVisible(false);
        FXMLHelper.showSuccessAlert(CONFIGURATION_SUCCESS, configurationPane);
        FXMLHelper.navigateTo(LOGIN, configurationPane);
    }

    @FXML
    public void applicationExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    private boolean configIsInvalid() {
        return serverIp.getText().isEmpty() || serverPort.getText().isEmpty();
    }

    private Properties getServerProperties() {
        Properties properties = new Properties();
        properties.put("tcp.target-server.host", serverIp.getText());
        properties.put("tcp.target-server.port", serverPort.getText());
        return properties;
    }

}
