package utfpr.constructionmaterials.server.services.transactionsService;

import utfpr.constructionmaterials.events.transactions.ClientTransactionListDTO;
import utfpr.constructionmaterials.replyEvents.transactions.ClientTransactionsReplyDTO;

public interface TransactionsService {

    ClientTransactionsReplyDTO list(ClientTransactionListDTO clientTransactionListDTO);

}
