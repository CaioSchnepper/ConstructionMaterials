package utfpr.constructionmaterials.events.donations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDTO {

    private Long quantity;

    private String measureUnit;

    private String description;

    private String idDonor;

}
