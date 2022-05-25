package utfpr.constructionmaterials.replyEvents.connection;

import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.replyEvents.success.EmptyObject;

public class PingReplyDTO implements EventDTO {

    private final EmptyObject ping = new EmptyObject();

}
