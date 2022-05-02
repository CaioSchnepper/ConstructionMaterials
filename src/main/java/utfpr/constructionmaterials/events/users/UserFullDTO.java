package utfpr.constructionmaterials.events.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.replyEvents.users.UserLoginReplyDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFullDTO {

    private String Id;

    private String name;

    private String cpf;

    private String password;

    private String phone;

    public UserLoginReplyDTO toLoginReplyDTO() {
        return new UserLoginReplyDTO(this);
    }

}