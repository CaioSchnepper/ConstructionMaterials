package utfpr.constructionmaterials.server.services.connectionService;

import org.springframework.stereotype.Service;
import utfpr.constructionmaterials.events.connection.CloseConnectionDTO;
import utfpr.constructionmaterials.replyEvents.connection.CloseConnectionReplyDTO;

@Service
public class ConnectionServiceImpl implements ConnectionService{

    @Override
    public CloseConnectionReplyDTO close(CloseConnectionDTO closeDTO) {
        return new CloseConnectionReplyDTO();
    }

}
