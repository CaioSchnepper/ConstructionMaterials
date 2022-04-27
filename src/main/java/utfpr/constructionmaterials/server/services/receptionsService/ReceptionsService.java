package utfpr.constructionmaterials.server.services.receptionsService;

import utfpr.constructionmaterials.events.receptions.ReceptionCreateDTO;
import utfpr.constructionmaterials.events.receptions.ReceptionListDTO;
import utfpr.constructionmaterials.replyEvents.receptions.ReceptionCreateReplyDTO;
import utfpr.constructionmaterials.replyEvents.receptions.ReceptionReplyDTO;

public interface ReceptionsService {

    ReceptionCreateReplyDTO create(ReceptionCreateDTO donationCreateDTO);

    ReceptionReplyDTO list(ReceptionListDTO receptionListDTO);

}
