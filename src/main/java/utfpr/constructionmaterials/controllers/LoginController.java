package utfpr.constructionmaterials.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Controller;
import utfpr.constructionmaterials.client.services.clientMessageService.ClientMessageHelper;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.users.UserLoginDTO;
import utfpr.constructionmaterials.events.users.UserSimpleDTO;
import utfpr.constructionmaterials.replyEvents.errors.LoginErrorDTO;
import utfpr.constructionmaterials.replyEvents.users.UserLoginReplyDTO;
import utfpr.constructionmaterials.shared.constants.ErrorMessages;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;
import utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper;
import utfpr.constructionmaterials.shared.singletons.CurrentUser;

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
            FXMLHelper.showErrorAlert(ErrorMessages.MISSING_FIELDS);
            return;
        }

        UserLoginDTO loginDTO = new UserSimpleDTO(cpf.getText(), password.getText()).toUserLoginDTO();

        EventDTO result = ClientMessageHelper.send(loginDTO);

        if (result instanceof LoginErrorDTO) {
            FXMLHelper.showErrorAlert(((LoginErrorDTO) result).getLogin().getError());
        } else {
            User user = ObjectMapperHelper.map(((UserLoginReplyDTO) result).getLogin(), User.class);
            CurrentUser.setInstance(user);
            FXMLHelper.showSuccessAlert(LOGIN_SUCCESS);
            FXMLHelper.navigateTo(HOME, loginPane);
        }
    }

    @FXML
    public void navigateToRegister() {
        FXMLHelper.navigateTo(REGISTER, loginPane);
    }

    private boolean userIsInvalid() {
        return cpf.getText().isEmpty() || password.getText().isEmpty();
    }

}

