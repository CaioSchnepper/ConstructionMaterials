package utfpr.constructionmaterials.entities.registers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import utfpr.constructionmaterials.entities.events.EventType;
import utfpr.constructionmaterials.entities.users.User;

@Getter
@Setter
@AllArgsConstructor
public class Register implements EventType {

    private User user;

}
