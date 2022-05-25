package utfpr.constructionmaterials.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ServerViewController {
    @FXML
    private TableView usersTable;
    @FXML
    private TableColumn userPort;
    @FXML
    private TextField serverStatus;
    @FXML
    private TextField serverIp;
    @FXML
    private TableColumn userIp;
    @FXML
    private TextField serverPort;
    @FXML
    private TableColumn userName;
    @FXML
    private Pane serverViewPane;

    @FXML
    public void stop(ActionEvent actionEvent) {
    }

    @FXML
    public void start(ActionEvent actionEvent) {
    }
}
