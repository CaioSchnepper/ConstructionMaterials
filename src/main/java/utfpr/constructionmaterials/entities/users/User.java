package utfpr.constructionmaterials.entities.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    private Long id;

    private String name;

    private String cpf;

    private String password;

    private String phone;

}
