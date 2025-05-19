package ma.enset.bartiloussamaexamjee.repositories;

import ma.enset.bartiloussamaexamjee.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}
