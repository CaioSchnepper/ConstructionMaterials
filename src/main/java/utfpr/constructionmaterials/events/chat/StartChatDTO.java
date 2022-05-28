package utfpr.constructionmaterials.events.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartChatDTO implements EventDTO {

    private StartChatInnerDTO startChat;

}
