package utfpr.constructionmaterials.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ServerViewController {
    @javafx.fxml.FXML
    private TableView usersTable;
    @javafx.fxml.FXML
    private TableColumn userPort;
    @javafx.fxml.FXML
    private TextField serverStatus;
    @javafx.fxml.FXML
    private Pane homePane;
    @javafx.fxml.FXML
    private TextField serverIp;
    @javafx.fxml.FXML
    private TableColumn userIp;
    @javafx.fxml.FXML
    private TextField serverPort;
    @javafx.fxml.FXML
    private TableColumn userName;

    @javafx.fxml.FXML
    public void stop(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void start(ActionEvent actionEvent) {
    }
}
