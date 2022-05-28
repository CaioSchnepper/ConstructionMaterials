package utfpr.constructionmaterials.controllers;

import javafx.css.Style;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;

import java.net.URL;
import java.util.ResourceBundle;

import static utfpr.constructionmaterials.shared.constants.ClientConfigs.SERVER_STATUS_OFF;
import static utfpr.constructionmaterials.shared.constants.ClientConfigs.SERVER_STATUS_ON;
import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.HOME;

public class ServerViewController implements Initializable {
    @FXML
    private Label serverStatus;
    @FXML
    private TextField serverIp;
    @FXML
    private TextField serverPort;
    @FXML
    private TableView<User> usersTable;
    @FXML
    private TableColumn<User, String> userPort;
    @FXML
    private TableColumn<User, String> userIp;
    @FXML
    private TableColumn<User, String> userName;
    @FXML
    private Pane serverViewPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setServerStatusText(true);
    }

    @FXML
    public void stop(ActionEvent actionEvent) {
    }

    @FXML
    public void start(ActionEvent actionEvent) {
    }

    @FXML
    public void back(ActionEvent actionEvent) {
        FXMLHelper.navigateTo(HOME, serverViewPane);
    }

    private void setServerStatusText(boolean isWorking) {
        if (isWorking) {
            serverStatus.setText(SERVER_STATUS_ON);
            serverStatus.setStyle("-fx-text-fill: greenyellow;");
        } else {
            serverStatus.setText(SERVER_STATUS_OFF);
            serverStatus.setStyle("-fx-text-fill: red;");
        }
    }

}
