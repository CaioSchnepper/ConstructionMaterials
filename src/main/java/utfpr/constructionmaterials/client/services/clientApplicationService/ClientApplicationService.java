package utfpr.constructionmaterials.client.services.clientApplicationService;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import utfpr.constructionmaterials.client.ClientApplication;

import java.util.Properties;

@AllArgsConstructor
public class ClientApplicationService extends Service<Void> {
    private String serverIp;
    private String serverPort;

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {

            @Override
            protected Void call() {
                SpringApplication clientApplication = new SpringApplication(ClientApplication.class);
                clientApplication.setDefaultProperties(getServerProperties());
                clientApplication.run();
                return null;
            }

        };
    }

    private Properties getServerProperties() {
        Properties properties = new Properties();
        properties.put("tcp.target-server.host", serverIp);
        properties.put("tcp.target-server.port", serverPort);
        return properties;
    }

}
