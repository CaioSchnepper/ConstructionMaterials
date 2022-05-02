package utfpr.constructionmaterials.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Controller;
import utfpr.constructionmaterials.client.services.clientMessageService.ClientMessageHelper;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.users.UserLoginDTO;
import utfpr.constructionmaterials.events.users.UserSimpleDTO;
import utfpr.constructionmaterials.replyEvents.errors.LoginErrorDTO;
import utfpr.constructionmaterials.shared.constants.ErrorMessages;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;

import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.HOME;
import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.REGISTER;
import static utfpr.constructionmaterials.shared.constants.SuccessMessages.LOGIN_SUCCESS;

@Controller
public class LoginController {

    @FXML
    private TextField cpf;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField password;

    @FXML
    private Button registerButton;
    @FXML
    private Pane loginPane;

    @FXML
    public void login() {
        if (userIsInvalid()) {
            FXMLHelper.showErrorAlert(ErrorMessages.MISSING_FIELDS, loginPane);
            return;
        }

        UserLoginDTO loginDTO = new UserSimpleDTO(cpf.getText(), password.getText()).toUserLoginDTO();

        EventDTO result = ClientMessageHelper.send(loginDTO);

        //TODO Salvar usuario em memória

        if (result instanceof LoginErrorDTO) {
            FXMLHelper.showErrorAlert(((LoginErrorDTO) result).getLogin().getError(), loginPane);
        } else {
            FXMLHelper.showSuccessAlert(LOGIN_SUCCESS, loginPane);
            navigateToHome();
        }
    }

    @FXML
    public void navigateToRegister() {
        Parent registerPane = FXMLHelper.load(REGISTER);
        loginPane.getChildren().clear();
        loginPane.getScene().setRoot(registerPane);
    }

    private void navigateToHome() {
        Parent homePane = FXMLHelper.load(HOME);
        loginPane.getChildren().clear();
        loginPane.getScene().setRoot(homePane);
    }

    private boolean userIsInvalid() {
        return cpf.getText().isEmpty() || password.getText().isEmpty();
    }

}

