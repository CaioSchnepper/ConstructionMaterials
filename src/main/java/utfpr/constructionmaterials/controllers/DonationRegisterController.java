package utfpr.constructionmaterials.controllers;

import com.gluonhq.charm.glisten.control.DropdownButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class DonationRegisterController {
    @javafx.fxml.FXML
    private TextField amount;
    @javafx.fxml.FXML
    private DropdownButton unit;
    @javafx.fxml.FXML
    private Pane homePane;
    @javafx.fxml.FXML
    private TextField description;

    @javafx.fxml.FXML
    public void cancel(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void send(ActionEvent actionEvent) {
    }
}
