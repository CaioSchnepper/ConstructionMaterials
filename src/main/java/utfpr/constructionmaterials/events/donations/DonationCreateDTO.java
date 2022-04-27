package utfpr.constructionmaterials.events.donations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationCreateDTO implements EventDTO {

    private DonationDTO donation;

}
