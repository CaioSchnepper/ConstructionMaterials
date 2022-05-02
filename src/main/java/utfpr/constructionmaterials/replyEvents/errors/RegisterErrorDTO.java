package utfpr.constructionmaterials.replyEvents.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.events.Event;
import utfpr.constructionmaterials.events.EventDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterErrorDTO implements EventDTO {

    private ErrorDTO register;

}
