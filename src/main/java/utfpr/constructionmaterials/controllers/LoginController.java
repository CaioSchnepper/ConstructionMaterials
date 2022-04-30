package utfpr.constructionmaterials.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;
import utfpr.constructionmaterials.client.service.ClientMessageHelper;
import utfpr.constructionmaterials.events.users.UserLoginDTO;
import utfpr.constructionmaterials.events.users.UserSimpleDTO;

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
    public void login(ActionEvent actionEvent) {
        if (userIsInvalid()) return;
        UserLoginDTO loginDTO = new UserSimpleDTO(cpf.getText(), password.getText()).toUserLoginDTO();
        ClientMessageHelper.send(loginDTO);
    }

    @FXML
    public void register(ActionEvent actionEvent) {
    }

    private boolean userIsInvalid() {
        return cpf.getText().isEmpty() || password.getText().isEmpty();
    }

}

