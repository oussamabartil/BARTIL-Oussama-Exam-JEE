package ma.enset.bartiloussamaexamjee.repositories;

import ma.enset.bartiloussamaexamjee.entities.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
    List<Remboursement> findByCreditId(Long creditId);
    List<Remboursement> findByType(String type);
    List<Remboursement> findByDateBetween(Date dateDebut, Date dateFin);
}
