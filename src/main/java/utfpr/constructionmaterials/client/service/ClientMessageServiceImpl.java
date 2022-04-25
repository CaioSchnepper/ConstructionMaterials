package utfpr.constructionmaterials.client.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utfpr.constructionmaterials.client.gateway.TcpClientGateway;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.events.registers.RegisterDTO;

@Service
public class ClientMessageServiceImpl implements ClientMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientMessageServiceImpl.class);

    private TcpClientGateway tcpClientGateway;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public ClientMessageServiceImpl(TcpClientGateway tcpClientGateway) {
        this.tcpClientGateway = tcpClientGateway;
    }

    @SneakyThrows
    @Override
    public void sendMessage() {
        User user = new User(1L, "Caio", "123456", "123", "42069");
        RegisterDTO register = new RegisterDTO(user);

        String jsonRegister = objectMapper.writeValueAsString(register);
        LOGGER.info("Send message: {}", jsonRegister);
        byte[] responseBytes = tcpClientGateway.send(jsonRegister.getBytes());
        String response = new String(responseBytes);
        LOGGER.info("Receive response: {}", response);
    }

}
