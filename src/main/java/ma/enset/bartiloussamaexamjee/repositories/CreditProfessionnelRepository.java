package ma.enset.bartiloussamaexamjee.repositories;

import ma.enset.bartiloussamaexamjee.entities.CreditProfessionnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditProfessionnelRepository extends JpaRepository<CreditProfessionnel, Long> {
    List<CreditProfessionnel> findByRaisonSociale(String raisonSociale);
}