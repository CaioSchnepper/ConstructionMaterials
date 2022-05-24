package utfpr.constructionmaterials.replyEvents.donations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.replyEvents.success.EmptyObject;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationCreateReplyDTO implements EventDTO {

    private EmptyObject donation = new EmptyObject();

}
