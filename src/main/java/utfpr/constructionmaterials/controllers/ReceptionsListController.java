package utfpr.constructionmaterials.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import utfpr.constructionmaterials.client.services.clientMessageService.ClientMessageHelper;
import utfpr.constructionmaterials.entities.donations.Donation;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.receptions.ReceptionListDTO;
import utfpr.constructionmaterials.replyEvents.errors.ReceptionsErrorDTO;
import utfpr.constructionmaterials.replyEvents.receptions.ReceptionListReplyDTO;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;
import utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.HOME;

public class ReceptionsListController implements Initializable {
    @FXML
    private TableView<Donation> receptionsTable;
    @FXML
    private Pane receptionsListPane;
    @FXML
    private TableColumn<Donation, Long> amount;
    @FXML
    private TableColumn<Donation, String> unit;
    @FXML
    private TableColumn<Donation, String> description;
    @FXML
    private TableColumn<Donation, String> id;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateList(new ActionEvent());
        setColumnsProperties();
    }

    @FXML
    public void menu(ActionEvent actionEvent) {
        FXMLHelper.navigateTo(HOME, receptionsListPane);
    }

    @FXML
    public void updateList(ActionEvent actionEvent) {
        EventDTO result = ClientMessageHelper.send(new ReceptionListDTO());

        if (result instanceof ReceptionsErrorDTO) {
            FXMLHelper.showErrorAlert(((ReceptionsErrorDTO) result).getReceptions().getError(), receptionsListPane);
        }

        if (result instanceof ReceptionListReplyDTO) {
            List<Donation> donations = ((ReceptionListReplyDTO) result)
                    .getReceptions()
                    .getDonations()
                    .stream()
                    .map(donation -> ObjectMapperHelper.map(donation, Donation.class))
                    .collect(Collectors.toList());

            ObservableList<Donation> tableItems = FXCollections.observableArrayList();
            tableItems.addAll(donations);
            receptionsTable.setItems(tableItems);
        }

    }

    private void setColumnsProperties() {
        amount.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unit.setCellValueFactory(new PropertyValueFactory<>("measureUnit"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
    }
}
