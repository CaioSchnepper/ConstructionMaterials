package utfpr.constructionmaterials.server.services.serverApplicationService;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import utfpr.constructionmaterials.server.ServerApplication;

import java.util.Properties;

@AllArgsConstructor
public class ServerApplicationService extends Service<Void> {
    private String serverIp;
    private String serverPort;

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {

            @Override
            protected Void call() {
                SpringApplication serverApplication = new SpringApplication(ServerApplication.class);
                serverApplication.setDefaultProperties(getServerProperties());
                serverApplication.run();
                return null;
            }

        };
    }

    private Properties getServerProperties() {
        Properties properties = new Properties();
        properties.put("tcp.server.host", serverIp);
        properties.put("tcp.server.port", serverPort);
        return properties;
    }

}