package utfpr.constructionmaterials.client.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import utfpr.constructionmaterials.client.service.ClientMessageService;

import static utfpr.constructionmaterials.shared.constants.ClientConfigs.KEEP_ALIVE_DELAY;

@Component
public class MessageJobScheduler {

    private ClientMessageService clientMessageService;

    @Autowired
    public MessageJobScheduler(ClientMessageService clientMessageService) {
        this.clientMessageService = clientMessageService;
    }

    @Scheduled(fixedDelay = KEEP_ALIVE_DELAY)
    public void sendMessageJob() {
        clientMessageService.sendMessage();
    }

}
