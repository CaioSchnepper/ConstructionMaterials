package utfpr.constructionmaterials.events.transactions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientTransactionListDTO implements EventDTO {

    private ClientTransactionDTO clientTransactions;

}
