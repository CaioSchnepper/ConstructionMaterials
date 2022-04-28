package utfpr.constructionmaterials.entities.donations;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("Donations")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Donation {

    @Id
    private String id = UUID.randomUUID().toString();

    @NonNull
    private Long quantity;

    @NonNull
    private String measureUnit;

    @NonNull
    private String description;

    @NonNull
    private String idDonor;

}