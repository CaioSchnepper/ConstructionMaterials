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
import utfpr.constructionmaterials.entities.receptions.Reception;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.transactions.ClientTransactionDTO;
import utfpr.constructionmaterials.events.transactions.ClientTransactionListDTO;
import utfpr.constructionmaterials.replyEvents.errors.TransactionsErrorDTO;
import utfpr.constructionmaterials.replyEvents.transactions.ClientTransactionsReplyDTO;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;
import utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper;
import utfpr.constructionmaterials.shared.singletons.CurrentUser;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.HOME;

public class TransactionsListController implements Initializable {
    @FXML
    private TableView<Reception> receptionsTable;
    @FXML
    private TableView<Donation> donationsTable;
    @FXML
    private TableColumn<Reception, Long> amountReception;
    @FXML
    private TableColumn<Reception, String> idReception;
    @FXML
    private TableColumn<Reception, String> idDonationReception;
    @FXML
    private TableColumn<Reception, String> idReceiverReception;
    @FXML
    private TableColumn<Donation, Long> amountDonation;
    @FXML
    private TableColumn<Donation, String> idDonation;
    @FXML
    private TableColumn<Donation, String> unitDonation;
    @FXML
    private TableColumn<Donation, String> descriptionDonation;
    @FXML
    private Pane transactionsListPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateTables();
        setColumnsProperties();
    }

    @FXML
    public void menu(ActionEvent actionEvent) {
        FXMLHelper.navigateTo(HOME, transactionsListPane);
    }

    private void populateTables() {
        EventDTO result = ClientMessageHelper
                .send(new ClientTransactionDTO(CurrentUser.getInstance().getUser().getId())
                        .toClientTransactionListDTO());

        if (result instanceof TransactionsErrorDTO) {
            FXMLHelper.showErrorAlert(((TransactionsErrorDTO) result).getClientTransactions().getError(), transactionsListPane);
        } else if (result instanceof ClientTransactionsReplyDTO) {
            List<Donation> donations = ((ClientTransactionsReplyDTO) result)
                    .getClientTransactions()
                    .getDonations()
                    .stream()
                    .map(donation -> ObjectMapperHelper.map(donation, Donation.class))
                    .collect(Collectors.toList());

            ObservableList<Donation> donationsTableItems = FXCollections.observableArrayList();
            donationsTableItems.addAll(donations);
            donationsTable.setItems(donationsTableItems);

            List<Reception> receptions = ((ClientTransactionsReplyDTO) result)
                    .getClientTransactions()
                    .getReceives()
                    .stream()
                    .map(reception -> ObjectMapperHelper.map(reception, Reception.class))
                    .collect(Collectors.toList());

            ObservableList<Reception> receptionsTableItems = FXCollections.observableArrayList();
            receptionsTableItems.addAll(receptions);
            receptionsTable.setItems(receptionsTableItems);
        }
    }

    private void setColumnsProperties() {
        amountDonation.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unitDonation.setCellValueFactory(new PropertyValueFactory<>("measureUnit"));
        descriptionDonation.setCellValueFactory(new PropertyValueFactory<>("description"));
        idDonation.setCellValueFactory(new PropertyValueFactory<>("id"));

        amountReception.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        idDonationReception.setCellValueFactory(new PropertyValueFactory<>("idDonation"));
        idReceiverReception.setCellValueFactory(new PropertyValueFactory<>("idReceiver"));
        idReception.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

}
