package utfpr.constructionmaterials.server.services.transactionsService;

import org.springframework.stereotype.Service;
import utfpr.constructionmaterials.events.transactions.ClientTransactionListDTO;
import utfpr.constructionmaterials.replyEvents.transactions.ClientTransactionsReplyDTO;

@Service
public class TransactionsServiceImpl implements TransactionsService{

    @Override
    public ClientTransactionsReplyDTO list(ClientTransactionListDTO clientTransactionListDTO) {
        return null;
    }

}
