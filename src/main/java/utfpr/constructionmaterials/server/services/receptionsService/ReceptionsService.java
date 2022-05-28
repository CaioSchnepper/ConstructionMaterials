package utfpr.constructionmaterials.server.services.receptionsService;

import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.receptions.ReceptionCreateDTO;
import utfpr.constructionmaterials.events.receptions.ReceptionListDTO;

public interface ReceptionsService {

    EventDTO create(ReceptionCreateDTO receptionCreateDTO);

    EventDTO list(ReceptionListDTO receptionListDTO);

}
