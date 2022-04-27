package utfpr.constructionmaterials.events.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSimpleDTO {

    private String cpf;

    private String password;

}
