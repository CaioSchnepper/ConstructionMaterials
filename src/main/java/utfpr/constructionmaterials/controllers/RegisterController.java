package utfpr.constructionmaterials.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utfpr.constructionmaterials.client.services.clientMessageService.ClientMessageHelper;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.users.UserDTO;
import utfpr.constructionmaterials.events.users.UserRegisterDTO;
import utfpr.constructionmaterials.replyEvents.errors.RegisterErrorDTO;
import utfpr.constructionmaterials.shared.constants.ErrorMessages;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;

import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.LOGIN;
import static utfpr.constructionmaterials.shared.constants.SuccessMessages.REGISTER_SUCCESS;

public class RegisterController {
    @FXML
    private TextField name;
    @FXML
    private PasswordField password;
    @FXML
    private TextField cpf;
    @FXML
    private TextField phone;
    @FXML
    private Button registerButton;
    @FXML
    private Button loginButton;
    @FXML
    private Pane registerPane;

    @FXML
    public void navigateToLogin() {
        Parent loginPane = FXMLHelper.load(LOGIN);
        registerPane.getChildren().clear();
        registerPane.getScene().setRoot(loginPane);
    }

    @FXML
    public void register() {
        if (userIsInvalid()) {
            FXMLHelper.showErrorAlert(ErrorMessages.MISSING_FIELDS, registerPane);
            return;
        }

        UserRegisterDTO registerDTO = new UserDTO(name.getText(), cpf.getText(), password.getText(), phone.getText())
                .toUserRegisterDTO();

        EventDTO result = ClientMessageHelper.send(registerDTO);

        if (result instanceof RegisterErrorDTO) {
            FXMLHelper.showErrorAlert(((RegisterErrorDTO) result).getRegister().getError(), registerPane);
        } else {
            FXMLHelper.showSuccessAlert(REGISTER_SUCCESS, registerPane);
            navigateToLogin();
        }
    }

    private boolean userIsInvalid() {
        return cpf.getText().isEmpty()
                || password.getText().isEmpty()
                || cpf.getText().isEmpty()
                || phone.getText().isEmpty();
    }

}
