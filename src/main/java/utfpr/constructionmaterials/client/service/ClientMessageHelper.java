package utfpr.constructionmaterials.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utfpr.constructionmaterials.events.EventDTO;

@Component
public class ClientMessageHelper {

    private static ClientMessageService clientMessageService;

    @Autowired
    public ClientMessageHelper(ClientMessageService clientMessageService) {
        ClientMessageHelper.clientMessageService = clientMessageService;
    }

    public static void send(EventDTO eventDTO) {
        clientMessageService.sendMessage(eventDTO);
    }

}
