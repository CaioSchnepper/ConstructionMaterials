package utfpr.constructionmaterials.replyEvents.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartChatReplyDTO implements EventDTO {

    private ChatReplyDTO startChat;

}
