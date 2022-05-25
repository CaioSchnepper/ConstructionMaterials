package utfpr.constructionmaterials.server.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import utfpr.constructionmaterials.events.connection.PingDTO;
import utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper;

import static utfpr.constructionmaterials.shared.constants.ServerConfigs.PING_DELAY;

@Component
@EnableScheduling
public class PingScheduler {

    private AbstractServerConnectionFactory serverConnectionFactory;

    @Autowired
    public PingScheduler(
            AbstractServerConnectionFactory serverConnectionFactory
    ) {
        this.serverConnectionFactory = serverConnectionFactory;
    }

    @Scheduled(fixedDelay = PING_DELAY)
    public void sendMessageJob() {
        byte[] ping = ObjectMapperHelper.mapToJson(new PingDTO()).getBytes();

        // Pega conexões ativas
        //List<String> eee = serverConnectionFactory.getOpenConnectionIds();

        // Fecha uma conexão
        //serverConnectionFactory.closeConnection(eee.stream().findFirst().get());

        //TODO: Find all active connections and ping, yes I'm a client, not a server
    }

}
