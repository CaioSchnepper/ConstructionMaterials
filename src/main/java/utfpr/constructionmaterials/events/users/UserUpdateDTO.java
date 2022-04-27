package utfpr.constructionmaterials.events.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO implements EventDTO {

    private UserFullDTO userUpdate;

}
