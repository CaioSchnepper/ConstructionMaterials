package utfpr.constructionmaterials.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utfpr.constructionmaterials.client.services.clientMessageService.ClientMessageHelper;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.users.UserDTO;
import utfpr.constructionmaterials.events.users.UserFullDTO;
import utfpr.constructionmaterials.events.users.UserRegisterDTO;
import utfpr.constructionmaterials.events.users.UserUpdateDTO;
import utfpr.constructionmaterials.replyEvents.errors.RegisterErrorDTO;
import utfpr.constructionmaterials.replyEvents.errors.UserUpdateErrorDTO;
import utfpr.constructionmaterials.shared.constants.ErrorMessages;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;
import utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper;
import utfpr.constructionmaterials.shared.singletons.CurrentUser;

import java.net.URL;
import java.util.ResourceBundle;

import static utfpr.constructionmaterials.shared.constants.ClientConfigs.RETURN_BUTTON_TEXT;
import static utfpr.constructionmaterials.shared.constants.ClientConfigs.UPDATE_BUTTON_TEXT;
import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.HOME;
import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.LOGIN;
import static utfpr.constructionmaterials.shared.constants.SuccessMessages.REGISTER_SUCCESS;
import static utfpr.constructionmaterials.shared.constants.SuccessMessages.USER_UPDATE_SUCCESS;

public class RegisterController implements Initializable {
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
    private Label alreadyHasRegister;

    private User currentUser;

    private boolean isUpdating = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (CurrentUser.getInstance() == null) return;
        currentUser = CurrentUser.getInstance().getUser();

        setExistingUserFields();
        replaceLoginFunctionality();
        isUpdating = true;
    }

    private void setExistingUserFields() {
        name.setText(currentUser.getName());
        password.setText(currentUser.getPassword());
        cpf.setText(currentUser.getCpf());
        phone.setText(currentUser.getPhone());
        registerButton.setText(UPDATE_BUTTON_TEXT);
    }

    private void replaceLoginFunctionality() {
        loginButton.setText(RETURN_BUTTON_TEXT);
        alreadyHasRegister.setVisible(false);
    }

    @FXML
    public void register() {
        if (userIsInvalid()) {
            FXMLHelper.showErrorAlert(ErrorMessages.MISSING_FIELDS);
            return;
        }

        if (isUpdating) {
            updateUser();
        } else {
            registerUser();
        }

    }

    @FXML
    public void navigateToLogin(ActionEvent actionEvent) {
        if (isUpdating) {
            FXMLHelper.navigateTo(HOME, registerPane);
        } else {
            FXMLHelper.navigateTo(LOGIN, registerPane);
        }
    }

    private void registerUser() {
        UserRegisterDTO registerDTO = new UserDTO(name.getText(), cpf.getText(), password.getText(), phone.getText())
                .toUserRegisterDTO();

        EventDTO result = ClientMessageHelper.send(registerDTO);

        if (result instanceof RegisterErrorDTO) {
            FXMLHelper.showErrorAlert(((RegisterErrorDTO) result).getRegister().getError());
        } else {
            FXMLHelper.showSuccessAlert(REGISTER_SUCCESS);
            FXMLHelper.navigateTo(LOGIN, registerPane);
        }
    }

    private void updateUser() {
        UserUpdateDTO updateDTO = new UserFullDTO(
                currentUser.getId(), name.getText(), cpf.getText(), password.getText(), phone.getText()
        ).toUserUpdateDTO();

        EventDTO result = ClientMessageHelper.send(updateDTO);

        if (result instanceof UserUpdateErrorDTO) {
            FXMLHelper.showErrorAlert(((UserUpdateErrorDTO) result).getUserUpdate().getError());
        } else {
            User user = ObjectMapperHelper.map(updateDTO.getUserUpdate(), User.class);
            CurrentUser.destroyInstance();
            CurrentUser.setInstance(user);
            FXMLHelper.showSuccessAlert(USER_UPDATE_SUCCESS);
            FXMLHelper.navigateTo(HOME, registerPane);
        }
    }

    private boolean userIsInvalid() {
        return cpf.getText().isEmpty()
                || password.getText().isEmpty()
                || cpf.getText().isEmpty()
                || phone.getText().isEmpty();
    }

}
