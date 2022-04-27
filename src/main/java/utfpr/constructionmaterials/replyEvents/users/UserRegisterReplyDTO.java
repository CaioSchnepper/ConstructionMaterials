package utfpr.constructionmaterials.replyEvents.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterReplyDTO implements EventDTO {

    private String register = "{ }";

}