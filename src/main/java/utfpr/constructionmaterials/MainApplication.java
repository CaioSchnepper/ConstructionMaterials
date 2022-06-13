package utfpr.constructionmaterials;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utfpr.constructionmaterials.client.ClientApplication;
import utfpr.constructionmaterials.server.ServerApplication;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;
import utfpr.constructionmaterials.shared.singletons.CurrentIcon;

import static utfpr.constructionmaterials.shared.constants.ClientConfigs.APPLICATION_TITLE;
import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.CONFIGURATION;

@SpringBootApplication
public class MainApplication extends Application {

    public static void main(String[] args) {
        // Start the server
        // The server interface will do that
        SpringApplication.run(ServerApplication.class, args);

        // Start the client
        // The Configuration Pane does this
        //SpringApplication.run(ClientApplication.class, args);

        // Start the JavaFX crap
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent configuration = FXMLHelper.load(CONFIGURATION);
        CurrentIcon.createInstance();
        primaryStage.setScene(new Scene(configuration));
        primaryStage.show();
        primaryStage.setTitle(APPLICATION_TITLE);
        primaryStage.getIcons().add(CurrentIcon.getInstance().getIcon());
        primaryStage.setOnCloseRequest(event -> System.exit(0));
    }

}
