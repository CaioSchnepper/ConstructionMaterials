package utfpr.constructionmaterials.replyEvents.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationErrorDTO implements EventDTO {

    private ErrorDTO donation;

}