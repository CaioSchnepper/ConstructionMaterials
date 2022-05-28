package utfpr.constructionmaterials.server.services.chatService;

import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.chat.ChatDTO;
import utfpr.constructionmaterials.events.chat.ChatRedirectionDTO;
import utfpr.constructionmaterials.events.chat.StartChatDTO;

public interface ChatService {

    EventDTO startChat(StartChatDTO startChatDTO);

    EventDTO chat(ChatDTO chatDTO);

    EventDTO chatRedirection(ChatRedirectionDTO chatRedirectionDTO);

}
