package utfpr.constructionmaterials.client.services.clientMessageService;

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

    public static EventDTO send(EventDTO eventDTO) {
        return clientMessageService.sendMessage(eventDTO);
    }

}
