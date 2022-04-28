package utfpr.constructionmaterials.entities.users;

import lombok.*;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("Users")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id = UUID.randomUUID().toString();

    @NonNull
    private String name;

    @NonNull
    private String cpf;

    @NonNull
    private String password;

    @NonNull
    private String phone;

}
