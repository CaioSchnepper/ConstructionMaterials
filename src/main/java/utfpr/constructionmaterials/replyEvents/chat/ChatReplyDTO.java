package utfpr.constructionmaterials.replyEvents.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.donations.DonationFullDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatReplyDTO {

    private String idReceptor;

    private DonationFullDTO donation;

}
