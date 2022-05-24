package utfpr.constructionmaterials.replyEvents.donations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.replyEvents.success.EmptyObject;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDeleteReplyDTO implements EventDTO {

    private EmptyObject donationDelete = new EmptyObject();

}
