package utfpr.constructionmaterials.replyEvents.receptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.donations.DonationFullDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionReplyDTO implements EventDTO {

    private List<DonationFullDTO> donations;

    public ReceptionListReplyDTO toReceptionListReplyDTO() {
        return new ReceptionListReplyDTO(this);
    }

}
