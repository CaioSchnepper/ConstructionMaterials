package utfpr.constructionmaterials.server.services.chatService;

import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.chat.ChatDTO;
import utfpr.constructionmaterials.events.chat.ChatRedirectionDTO;
import utfpr.constructionmaterials.events.chat.StartChatDTO;
import utfpr.constructionmaterials.replyEvents.chat.StartChatReplyDTO;
import utfpr.constructionmaterials.replyEvents.errors.ChatErrorDTO;
import utfpr.constructionmaterials.replyEvents.errors.ChatRedirectionErrorDTO;

public class ChatServiceImpl implements ChatService {

    @Override
    public EventDTO startChat(StartChatDTO startChatDTO) {
        return new StartChatReplyDTO();
    }

    @Override
    public EventDTO chat(ChatDTO chatDTO) {
        return new ChatErrorDTO(); //TODO
    }

    @Override
    public EventDTO chatRedirection(ChatRedirectionDTO chatRedirectionDTO) {
        return new ChatRedirectionErrorDTO(); //TODO
    }
}
