package utfpr.constructionmaterials.entities.donations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Donations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donation {

    @Id
    private Long id;

    private Long quantity;

    private String measureUnit;

    private String description;

    private String idDonor;

}