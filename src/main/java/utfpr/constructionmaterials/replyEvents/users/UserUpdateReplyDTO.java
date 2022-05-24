package utfpr.constructionmaterials.replyEvents.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.replyEvents.success.EmptyObject;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateReplyDTO implements EventDTO {

    private EmptyObject userUpdate = new EmptyObject();

}