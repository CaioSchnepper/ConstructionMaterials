package utfpr.constructionmaterials.entities.receptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Receptions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reception {

    @Id
    private Long id;

    private Long quantity;

    private String idDonation;

    private String idReceiver;

}