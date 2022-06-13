package utfpr.constructionmaterials.server;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utfpr.constructionmaterials.shared.helpers.FXMLHelper;
import utfpr.constructionmaterials.shared.singletons.CurrentIcon;

import static utfpr.constructionmaterials.shared.constants.ClientConfigs.APPLICATION_TITLE;
import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.CONFIGURATION;
import static utfpr.constructionmaterials.shared.constants.FXMLFileNames.SERVER_VIEW;

@SpringBootApplication
public class ServerApplication extends Application {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent serverView = FXMLHelper.load(SERVER_VIEW);
        CurrentIcon.createInstance();
        primaryStage.setScene(new Scene(serverView));
        primaryStage.show();
        primaryStage.setTitle(APPLICATION_TITLE);
        primaryStage.getIcons().add(CurrentIcon.getInstance().getIcon());
        primaryStage.setOnCloseRequest(event -> System.exit(0));
    }
}
