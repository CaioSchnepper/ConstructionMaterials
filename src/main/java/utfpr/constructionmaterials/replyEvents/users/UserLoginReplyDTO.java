package utfpr.constructionmaterials.replyEvents.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.users.UserFullDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginReplyDTO implements EventDTO {

    private UserFullDTO login;

}
