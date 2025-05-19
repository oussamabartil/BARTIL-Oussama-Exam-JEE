package ma.enset.bartiloussamaexamjee.repositories;

import ma.enset.bartiloussamaexamjee.entities.CreditImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier, Long> {
    List<CreditImmobilier> findByTypeBien(String typeBien);
}