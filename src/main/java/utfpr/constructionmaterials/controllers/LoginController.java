package utfpr.constructionmaterials.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utfpr.constructionmaterials.events.users.UserLoginDTO;
import utfpr.constructionmaterials.events.users.UserSimpleDTO;

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
    public void login(ActionEvent actionEvent) {
        if (isUserNotValid()) return;
        UserSimpleDTO userSimpleDTO = new UserSimpleDTO(cpf.getText(), password.getText());
        UserLoginDTO userLoginDTO = new UserLoginDTO(userSimpleDTO);
        //clientMessageService.sendMessage(userLoginDTO);
    }

    @FXML
    public void register(ActionEvent actionEvent) {
    }

    private boolean isUserNotValid() {
        return cpf.getText().isEmpty() || password.getText().isEmpty();
    }
}

