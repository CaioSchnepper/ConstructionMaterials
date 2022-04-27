package utfpr.constructionmaterials.server.repositories.donations;

import org.springframework.data.mongodb.repository.MongoRepository;
import utfpr.constructionmaterials.entities.donations.Donation;

public interface DonationsRepository extends MongoRepository<Donation, String> {
}
