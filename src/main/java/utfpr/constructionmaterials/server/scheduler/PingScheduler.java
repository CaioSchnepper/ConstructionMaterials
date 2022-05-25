package utfpr.constructionmaterials.server.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import utfpr.constructionmaterials.events.connection.PingDTO;
import utfpr.constructionmaterials.server.endpoint.TcpServerEndpoint;
import utfpr.constructionmaterials.server.services.serverMessageService.ServerMessageService;
import utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper;

import static utfpr.constructionmaterials.shared.constants.ServerConfigs.PING_DELAY;

@Component
@EnableScheduling
public class PingScheduler {

    @Autowired
    public PingScheduler() {
    }

    @Scheduled(fixedDelay = PING_DELAY)
    public void sendMessageJob() {
        byte[] ping = ObjectMapperHelper.mapToJson(new PingDTO()).getBytes();
        //TODO: Find all active connections and ping, yes I'm a client, not a server
    }

}
