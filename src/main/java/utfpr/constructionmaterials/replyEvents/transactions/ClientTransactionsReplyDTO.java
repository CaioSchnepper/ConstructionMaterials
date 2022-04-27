package utfpr.constructionmaterials.replyEvents.transactions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientTransactionsReplyDTO implements EventDTO {

    private TransactionsReplyDTO clientTransactions;

}
