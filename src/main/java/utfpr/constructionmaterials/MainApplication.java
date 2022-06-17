package utfpr.constructionmaterials;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;
import utfpr.constructionmaterials.shared.singletons.CurrentIcon;

import static utfpr.constructionmaterials.shared.constants.ClientConfigs.APPLICATION_TITLE;
import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.CONFIGURATION;
import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.SERVER_VIEW;

@SpringBootApplication
public class MainApplication extends Application {

    public static void main(String[] args) {
        // Start the JavaFX crap
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Client application
        Parent configuration = FXMLHelper.load(CONFIGURATION);
        CurrentIcon.createInstance();
        primaryStage.setScene(new Scene(configuration));
        primaryStage.setTitle(APPLICATION_TITLE);
        primaryStage.getIcons().add(CurrentIcon.getInstance().getIcon());
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.show();

        // Server application
        Parent serverView = FXMLHelper.load(SERVER_VIEW);
        Stage serverViewStage = new Stage();
        serverViewStage.setScene(new Scene(serverView));
        serverViewStage.setTitle(APPLICATION_TITLE);
        serverViewStage.getIcons().add(CurrentIcon.getInstance().getIcon());
        serverViewStage.setOnCloseRequest(event -> System.exit(0));
        serverViewStage.show();
    }

}
