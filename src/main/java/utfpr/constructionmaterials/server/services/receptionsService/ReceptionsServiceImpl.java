package utfpr.constructionmaterials.server.services.receptionsService;

import org.springframework.stereotype.Component;
import utfpr.constructionmaterials.events.receptions.ReceptionCreateDTO;
import utfpr.constructionmaterials.events.receptions.ReceptionListDTO;
import utfpr.constructionmaterials.replyEvents.receptions.ReceptionCreateReplyDTO;
import utfpr.constructionmaterials.replyEvents.receptions.ReceptionReplyDTO;

@Component
public class ReceptionsServiceImpl implements ReceptionsService {

    @Override
    public ReceptionCreateReplyDTO create(ReceptionCreateDTO donationCreateDTO) {
        return null;
    }

    @Override
    public ReceptionReplyDTO list(ReceptionListDTO receptionListDTO) {
        return null;
    }

}
