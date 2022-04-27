package utfpr.constructionmaterials.replyEvents.donations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDeleteReplyDTO implements EventDTO {

    private String donationDelete = "{ }";

}
