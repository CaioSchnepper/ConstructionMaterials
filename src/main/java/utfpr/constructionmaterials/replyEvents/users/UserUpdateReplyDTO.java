package utfpr.constructionmaterials.replyEvents.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateReplyDTO implements EventDTO {

    private String userUpdate = "{ }";

}