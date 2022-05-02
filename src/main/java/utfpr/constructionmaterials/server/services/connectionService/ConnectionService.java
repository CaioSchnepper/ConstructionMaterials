package utfpr.constructionmaterials.server.services.connectionService;

import utfpr.constructionmaterials.events.connection.CloseConnectionDTO;
import utfpr.constructionmaterials.replyEvents.connection.CloseConnectionReplyDTO;

public interface ConnectionService {

    CloseConnectionReplyDTO close(CloseConnectionDTO closeDTO);

}
