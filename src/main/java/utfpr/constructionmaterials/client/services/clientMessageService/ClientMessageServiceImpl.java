package utfpr.constructionmaterials.client.services.clientMessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utfpr.constructionmaterials.client.gateway.TcpClientGateway;
import utfpr.constructionmaterials.client.managers.EventReplyProcessorManager;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper;

@Component
public class ClientMessageServiceImpl implements ClientMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientMessageServiceImpl.class);

    private final TcpClientGateway tcpClientGateway;

    @Autowired
    public ClientMessageServiceImpl(TcpClientGateway tcpClientGateway) {
        this.tcpClientGateway = tcpClientGateway;
    }

    @Override
    public EventDTO sendMessage(EventDTO eventDTO) {
        String eventJson = ObjectMapperHelper.mapToJson(eventDTO);

        LOGGER.info("Send message: {}", eventJson);

        byte[] responseBytes = tcpClientGateway.send(eventJson.getBytes());

        LOGGER.info("Receive response: {}", new String(responseBytes));

        String eventName = ObjectMapperHelper.getEventName(responseBytes);

        return EventReplyProcessorManager.processEventReply(eventName, responseBytes);
    }

}
