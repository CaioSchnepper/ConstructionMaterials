package utfpr.constructionmaterials.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;

import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.HOME;

public class TransactionsListController {
    @FXML
    private TableView receptionsTable;
    @FXML
    private TableView donationsTable;
    @FXML
    private Pane transactionsListPane;

    @FXML
    public void menu(ActionEvent actionEvent) {
        FXMLHelper.navigateTo(HOME, transactionsListPane);
    }
}
