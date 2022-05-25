package utfpr.constructionmaterials.events.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartChatInnerDTO {

    private String idReceptor;

    private String idDonation;

}
