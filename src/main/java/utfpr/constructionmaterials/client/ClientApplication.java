package utfpr.constructionmaterials.client;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utfpr.constructionmaterials.MainApplication;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;

import java.io.IOException;
import java.util.Objects;

import static utfpr.constructionmaterials.shared.constants.ClientConfigs.APPLICATION_TITLE;
import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.CONFIGURATION;

@SpringBootApplication
public class ClientApplication extends Application {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent login = FXMLHelper.load(CONFIGURATION);
        Image icon = new Image(Objects.requireNonNull(MainApplication.class.getClassLoader().getResourceAsStream("icon.png")));
        primaryStage.setScene(new Scene(login));
        primaryStage.show();
        primaryStage.setTitle(APPLICATION_TITLE);
        primaryStage.getIcons().add(icon);
    }
}
