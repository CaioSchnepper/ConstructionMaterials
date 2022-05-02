package utfpr.constructionmaterials.client.services.clientMessageService;

import utfpr.constructionmaterials.events.EventDTO;

public interface ClientMessageService {

    EventDTO sendMessage(EventDTO eventDTO);

}
