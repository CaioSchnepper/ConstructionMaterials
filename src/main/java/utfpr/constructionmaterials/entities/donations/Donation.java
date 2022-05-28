package utfpr.constructionmaterials.entities.donations;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import utfpr.constructionmaterials.events.donations.DonationUpdateDTO;

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

    public void updateFromDTO(DonationUpdateDTO donationUpdateDTO) {
        this.quantity = donationUpdateDTO.getDonationUpdate().getQuantity();
        this.measureUnit = donationUpdateDTO.getDonationUpdate().getMeasureUnit();
        this.description = donationUpdateDTO.getDonationUpdate().getDescription();
    }

}