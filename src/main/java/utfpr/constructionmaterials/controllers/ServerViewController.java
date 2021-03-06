package utfpr.constructionmaterials.controllers;

import com.gluonhq.charm.glisten.control.BottomNavigationButton;
import com.gluonhq.charm.glisten.control.ProgressBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.server.services.serverApplicationService.ServerApplicationService;
import utfpr.constructionmaterials.shared.constants.ErrorMessages;
import utfpr.constructionmaterials.shared.constants.ServerImages;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;

import java.net.URL;
import java.util.ResourceBundle;

import static utfpr.constructionmaterials.shared.constants.ServerConfigs.DEFAULT_IP;
import static utfpr.constructionmaterials.shared.constants.ServerConfigs.DEFAULT_PORT;
import static utfpr.constructionmaterials.shared.constants.SuccessMessages.SERVER_START_SUCCESS;

public class ServerViewController implements Initializable {
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #5a7f78; -fx-cursor: pointer;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #7bada4; -fx-cursor: hand;";
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
    @FXML
    private ProgressBar loadingBar;
    @FXML
    private ImageView serverStatus;
    @FXML
    private BottomNavigationButton startButton;
    @FXML
    private BottomNavigationButton stopButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setServerStatusText(false);
        loadingBar.setVisible(false);

        serverIp.setText(DEFAULT_IP);
        serverPort.setText(DEFAULT_PORT);

        startButton.setOnMouseEntered(event -> startButton.setStyle(HOVERED_BUTTON_STYLE));
        startButton.setOnMouseExited(event -> startButton.setStyle(IDLE_BUTTON_STYLE));
        stopButton.setOnMouseEntered(event -> stopButton.setStyle(HOVERED_BUTTON_STYLE));
        stopButton.setOnMouseExited(event -> stopButton.setStyle(IDLE_BUTTON_STYLE));
    }

    @FXML
    public void stop(ActionEvent actionEvent) {
    }

    @FXML
    public void start(ActionEvent actionEvent) {
        if (configIsInvalid()) {
            FXMLHelper.showErrorAlert(ErrorMessages.MISSING_FIELDS);
            return;
        }

        loadingBar.setVisible(true);

        final ServerApplicationService serverApplicationService = new ServerApplicationService(serverIp.getText(), serverPort.getText());

        serverApplicationService.setOnSucceeded(workerStateEvent -> {
            loadingBar.setVisible(false);
            FXMLHelper.showSuccessAlert(SERVER_START_SUCCESS);
            setServerStatusText(true);
        });

        serverApplicationService.setOnFailed(workerStateEvent -> {
            loadingBar.setVisible(false);
            FXMLHelper.showErrorAlert(ErrorMessages.SERVER_START_ERROR);
            setServerStatusText(false);
        });

        serverApplicationService.restart();
    }

    private void setServerStatusText(boolean isWorking) {
        if (isWorking) {
            serverStatus.setImage(ServerImages.ON);
        } else {
            serverStatus.setImage(ServerImages.OFF);
        }
    }

    private boolean configIsInvalid() {
        return serverIp.getText().isEmpty() || serverPort.getText().isEmpty();
    }

}
