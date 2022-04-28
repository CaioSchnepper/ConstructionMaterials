package utfpr.constructionmaterials.client.service;

import utfpr.constructionmaterials.events.EventDTO;

public interface ClientMessageService {

    void sendMessage(EventDTO eventDTO);

}
