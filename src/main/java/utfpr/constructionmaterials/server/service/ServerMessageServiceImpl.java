package utfpr.constructionmaterials.server.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServerMessageServiceImpl implements ServerMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerMessageServiceImpl.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] processMessage(byte[] message) {
        String messageContent = new String(message);
        LOGGER.info("Receive message: {}", messageContent);
        String responseContent = String.format("Message \"%s\" is processed", messageContent);
        return responseContent.getBytes();
    }

}
