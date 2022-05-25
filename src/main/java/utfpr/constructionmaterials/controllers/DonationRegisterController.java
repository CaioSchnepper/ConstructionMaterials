package utfpr.constructionmaterials.controllers;

import com.gluonhq.charm.glisten.control.DropdownButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class DonationRegisterController {
    @FXML
    private TextField amount;
    @FXML
    private DropdownButton unit;
    @FXML
    private TextField description;
    @FXML
    private Pane donationRegisterPane;

    @FXML
    public void cancel(ActionEvent actionEvent) {
    }

    @FXML
    public void send(ActionEvent actionEvent) {
    }
}
