package utfpr.constructionmaterials.entities.receptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;

@Document("Receptions")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Reception {

    @Id
    private String id = String.valueOf(new Random().nextInt(Integer.MAX_VALUE));

    @NonNull
    private Long quantity;

    @NonNull
    private String idDonation;

    @NonNull
    private String idReceiver;

}