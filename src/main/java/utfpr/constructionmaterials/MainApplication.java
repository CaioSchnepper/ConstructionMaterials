package utfpr.constructionmaterials;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utfpr.constructionmaterials.client.ClientApplication;
import utfpr.constructionmaterials.server.ServerApplication;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;

import java.io.IOException;
import java.util.Objects;

import static utfpr.constructionmaterials.shared.constants.ClientConfigs.APPLICATION_TITLE;
import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.LOGIN;

@SpringBootApplication
public class MainApplication extends Application {

    public static void main(String[] args) {
        // Start the server
        SpringApplication.run(ServerApplication.class, args);
        // Start the client
        SpringApplication.run(ClientApplication.class, args);
        // Start the JavaFX crap
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent login = FXMLHelper.load(LOGIN);
        Image icon = new Image(Objects.requireNonNull(MainApplication.class.getClassLoader().getResourceAsStream("icon.png")));
        primaryStage.setScene(new Scene(login));
        primaryStage.show();
        primaryStage.setTitle(APPLICATION_TITLE);
        primaryStage.getIcons().add(icon);
    }

}
