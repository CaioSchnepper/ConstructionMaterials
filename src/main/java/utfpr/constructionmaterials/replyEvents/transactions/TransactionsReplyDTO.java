package utfpr.constructionmaterials.replyEvents.transactions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.donations.DonationFullDTO;
import utfpr.constructionmaterials.events.receptions.ReceptionFullDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsReplyDTO {

    private List<DonationFullDTO> donations;

    private List<ReceptionFullDTO> receives;

}
