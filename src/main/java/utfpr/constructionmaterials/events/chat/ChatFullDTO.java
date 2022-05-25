package utfpr.constructionmaterials.events.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatFullDTO {

    private String idReceptor;

    private String idDonor;

    private String message;

}
