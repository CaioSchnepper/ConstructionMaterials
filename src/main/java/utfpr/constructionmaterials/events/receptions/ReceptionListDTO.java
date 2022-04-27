package utfpr.constructionmaterials.events.receptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionListDTO implements EventDTO {

    private String receptions = "{ }";

}
