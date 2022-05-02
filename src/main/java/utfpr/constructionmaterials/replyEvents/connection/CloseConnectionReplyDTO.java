package utfpr.constructionmaterials.replyEvents.connection;

import lombok.AllArgsConstructor;
import lombok.Data;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.replyEvents.success.EmptyObject;

@Data
@AllArgsConstructor
public class CloseConnectionReplyDTO implements EventDTO {

    private final EmptyObject close = new EmptyObject();

}
