package utfpr.constructionmaterials.server.services.transactionsService;

import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.transactions.ClientTransactionListDTO;

public interface TransactionsService {

    EventDTO list(ClientTransactionListDTO clientTransactionListDTO);

}
