package utfpr.constructionmaterials.client.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utfpr.constructionmaterials.client.gateway.TcpClientGateway;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.events.users.UserDTO;
import utfpr.constructionmaterials.events.users.UserRegisterDTO;
import utfpr.constructionmaterials.shared.helpers.JsonHelper;

@Service
public class ClientMessageServiceImpl implements ClientMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientMessageServiceImpl.class);

    private final TcpClientGateway tcpClientGateway;

    @Autowired
    public ClientMessageServiceImpl(TcpClientGateway tcpClientGateway) {
        this.tcpClientGateway = tcpClientGateway;
    }

    @Override
    public void sendMessage() {
        User user = new User("Caio", "123456", "123", "42069");
        UserDTO userDTO = JsonHelper.map(user, UserDTO.class);
        UserRegisterDTO register = new UserRegisterDTO(userDTO);

        String jsonRegister = JsonHelper.mapToJson(register);
        LOGGER.info("Send message: {}", jsonRegister);
        byte[] responseBytes = tcpClientGateway.send(jsonRegister.getBytes());
        String response = new String(responseBytes);
        LOGGER.info("Receive response: {}", response);
    }

}
