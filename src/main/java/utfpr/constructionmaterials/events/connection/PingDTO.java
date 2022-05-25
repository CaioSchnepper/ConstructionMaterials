package utfpr.constructionmaterials.events.connection;

import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.replyEvents.success.EmptyObject;

public class PingDTO implements EventDTO {

    private final EmptyObject ping = new EmptyObject();

}
