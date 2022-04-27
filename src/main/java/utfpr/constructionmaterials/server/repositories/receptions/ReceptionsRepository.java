package utfpr.constructionmaterials.server.repositories.receptions;

import org.springframework.data.mongodb.repository.MongoRepository;
import utfpr.constructionmaterials.entities.receptions.Reception;

public interface ReceptionsRepository extends MongoRepository<Reception, String> {
}
