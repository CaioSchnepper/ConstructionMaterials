package utfpr.constructionmaterials.server.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import utfpr.constructionmaterials.server.services.serverMessageService.ServerMessageService;

@MessageEndpoint
public class TcpServerEndpoint {

    private final ServerMessageService serverMessageService;

    @Autowired
    public TcpServerEndpoint(ServerMessageService serverMessageService) {
        this.serverMessageService = serverMessageService;
    }

    @ServiceActivator(inputChannel = "inboundChannel")
    public byte[] process(byte[] message) {
        return serverMessageService.processMessage(message);
    }

}
