package utfpr.constructionmaterials;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utfpr.constructionmaterials.client.ClientApplication;
import utfpr.constructionmaterials.server.ServerApplication;

import java.io.IOException;
import java.util.Objects;

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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/login.fxml")));
        Image icon = new Image(Objects.requireNonNull(MainApplication.class.getClassLoader().getResourceAsStream("icon.png")));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setTitle("Construction Materials");
        primaryStage.getIcons().add(icon);
    }

}
