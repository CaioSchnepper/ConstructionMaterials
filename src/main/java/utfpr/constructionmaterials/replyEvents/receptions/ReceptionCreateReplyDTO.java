package utfpr.constructionmaterials.replyEvents.receptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.replyEvents.success.EmptyObject;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionCreateReplyDTO implements EventDTO {

    private EmptyObject receive = new EmptyObject();

}