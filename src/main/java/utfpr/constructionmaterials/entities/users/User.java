package utfpr.constructionmaterials.entities.users;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;

@Document("Users")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id = String.valueOf(new Random().nextInt(Integer.MAX_VALUE));

    @NonNull
    private String name;

    @NonNull
    private String cpf;

    @NonNull
    private String password;

    @NonNull
    private String phone;

}
