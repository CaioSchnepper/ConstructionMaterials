package utfpr.constructionmaterials.events.registers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO implements EventDTO {

    private User register;

}
