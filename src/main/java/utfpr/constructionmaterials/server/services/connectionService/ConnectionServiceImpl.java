package utfpr.constructionmaterials.server.services.connectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;
import utfpr.constructionmaterials.events.connection.CloseConnectionDTO;
import utfpr.constructionmaterials.replyEvents.connection.CloseConnectionReplyDTO;

@Service
public class ConnectionServiceImpl implements ConnectionService{

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Override
    public CloseConnectionReplyDTO close(CloseConnectionDTO closeDTO) {
        applicationContext.close();
        return new CloseConnectionReplyDTO();
    }

}
