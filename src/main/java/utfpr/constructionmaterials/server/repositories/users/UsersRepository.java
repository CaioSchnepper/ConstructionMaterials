package utfpr.constructionmaterials.server.repositories.users;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import utfpr.constructionmaterials.entities.users.User;

public interface UsersRepository extends MongoRepository<User, String> {

    @Query("{cpf:'?0'}")
    User findByCpf(String cpf);

    boolean existsByCpf(String cpf);

}
