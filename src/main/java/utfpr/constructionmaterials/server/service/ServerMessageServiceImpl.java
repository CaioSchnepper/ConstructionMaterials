package utfpr.constructionmaterials.server.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utfpr.constructionmaterials.server.repositories.users.UsersRepository;

@Service
public class ServerMessageServiceImpl implements ServerMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerMessageServiceImpl.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public byte[] processMessage(byte[] message) {
        String eventName;
        try {
            eventName = objectMapper.readTree(message).fields().next().getKey();
            LOGGER.info("Received event name: {}", eventName);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

//        TODO: Switch case boladão

//        Ja está funcional, comentado para poupar o banco
//
//        try {
//            RegisterDTO registerDTO = objectMapper.readValue(message, RegisterDTO.class);
//            usersRepository.save(registerDTO.getRegister());
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }

        return String.format("Received event name:" + eventName).getBytes();
    }

}
