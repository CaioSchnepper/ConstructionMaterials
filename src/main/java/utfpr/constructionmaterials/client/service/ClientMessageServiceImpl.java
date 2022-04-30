package utfpr.constructionmaterials.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utfpr.constructionmaterials.client.gateway.TcpClientGateway;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.shared.helpers.JsonHelper;

@Component
public class ClientMessageServiceImpl implements ClientMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientMessageServiceImpl.class);

    private final TcpClientGateway tcpClientGateway;

    @Autowired
    public ClientMessageServiceImpl(TcpClientGateway tcpClientGateway) {
        this.tcpClientGateway = tcpClientGateway;
    }

    @Override
    public void sendMessage(EventDTO eventDTO) {
        String eventJson = JsonHelper.mapToJson(eventDTO);
        LOGGER.info("Send message: {}", eventJson);
        byte[] responseBytes = tcpClientGateway.send(eventJson.getBytes());
        String response = new String(responseBytes);
        LOGGER.info("Receive response: {}", response);
    }

}
