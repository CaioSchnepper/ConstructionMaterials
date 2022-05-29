package utfpr.constructionmaterials.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utfpr.constructionmaterials.client.services.clientMessageService.ClientMessageHelper;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.donations.DonationCreateDTO;
import utfpr.constructionmaterials.events.donations.DonationDTO;
import utfpr.constructionmaterials.replyEvents.errors.DonationErrorDTO;
import utfpr.constructionmaterials.shared.constants.ErrorMessages;
import utfpr.constructionmaterials.shared.constants.MeasurementUnits;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;
import utfpr.constructionmaterials.shared.singletons.CurrentUser;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.HOME;
import static utfpr.constructionmaterials.shared.constants.SuccessMessages.DONATION_SUCCESS;

public class DonationRegisterController implements Initializable {
    @FXML
    private TextField amount;
    @FXML
    private TextField description;
    @FXML
    private Pane donationRegisterPane;
    @FXML
    private ComboBox<String> units;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addMeasurementUnits();
        addTextListener();
    }

    @FXML
    public void back(ActionEvent actionEvent) {
        FXMLHelper.navigateTo(HOME, donationRegisterPane);
    }

    @FXML
    public void send(ActionEvent actionEvent) {
        if (!fieldsAreValid()) {
            FXMLHelper.showErrorAlert(ErrorMessages.MISSING_FIELDS);
            return;
        }

        User currentUser = CurrentUser.getInstance().getUser();

        DonationCreateDTO donationCreateDTO = new DonationDTO(
                Long.parseLong(amount.getText()),
                units.getValue(),
                description.getText(),
                currentUser.getId())
                .toDonationCreateDTO();

        EventDTO result = ClientMessageHelper.send(donationCreateDTO);

        if (result instanceof DonationErrorDTO) {
            FXMLHelper.showErrorAlert(((DonationErrorDTO) result).getDonation().getError());
        } else {
            FXMLHelper.showSuccessAlert(DONATION_SUCCESS);
            FXMLHelper.navigateTo(HOME, donationRegisterPane);
        }

    }

    private boolean fieldsAreValid() {
        return !amount.getText().isEmpty()
                && !description.getText().isEmpty()
                && !units.getValue().isEmpty();
    }

    private void addMeasurementUnits() {
        ObservableList<String> items = FXCollections.observableArrayList();
        List<String> unitsList = Stream.of(MeasurementUnits.values()).map(Enum::name).collect(Collectors.toList());
        items.addAll(unitsList);
        units.setItems(items);
    }

    private void addTextListener() {
        amount.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                amount.setText(newValue.replaceAll("\\D", ""));
            }
        });
    }
}
