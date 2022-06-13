package utfpr.constructionmaterials.events.receptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionDTO {

    private Long quantity;

    private String idDonation;

    private String idReceiver;

    private String description;

    private String measureUnit;

}
