package utfpr.constructionmaterials.server.services.serverMessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.server.managers.EventProcessorManager;
import utfpr.constructionmaterials.shared.helpers.JsonHelper;

@Service
public class ServerMessageServiceImpl implements ServerMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerMessageServiceImpl.class);

    @Override
    public byte[] processMessage(byte[] message) {
        LOGGER.info("Received message: " + new String(message));

        String eventName = JsonHelper.getEventName(message);

        EventDTO reply = EventProcessorManager.processEvent(eventName, message);

        return JsonHelper.mapToJson(reply).getBytes();
    }

}
