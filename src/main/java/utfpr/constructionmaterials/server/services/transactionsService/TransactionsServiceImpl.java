package utfpr.constructionmaterials.server.services.transactionsService;

import org.springframework.stereotype.Component;
import utfpr.constructionmaterials.events.transactions.ClientTransactionListDTO;
import utfpr.constructionmaterials.replyEvents.transactions.ClientTransactionsReplyDTO;

@Component
public class TransactionsServiceImpl implements TransactionsService{

    @Override
    public ClientTransactionsReplyDTO list(ClientTransactionListDTO clientTransactionListDTO) {
        return null;
    }

}
