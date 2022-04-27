package utfpr.constructionmaterials.replyEvents.receptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionCreateReplyDTO implements EventDTO {

    private String receive = "{ }";

}