package utfpr.constructionmaterials.events.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private String name;

    private String cpf;

    private String password;

    private String phone;

    public UserRegisterDTO toUserRegisterDTO() {
        return new UserRegisterDTO(this);
    }

}
