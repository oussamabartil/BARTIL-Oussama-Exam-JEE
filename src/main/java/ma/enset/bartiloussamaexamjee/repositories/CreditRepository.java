package ma.enset.bartiloussamaexamjee.repositories;

import ma.enset.bartiloussamaexamjee.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {
    List<Credit> findByClientId(Long clientId);
    List<Credit> findByStatut(String statut);

    @Query("select c from Credit c where c.client.id = :clientId and c.statut = :statut")
    List<Credit> findByClientIdAndStatut(@Param("clientId") Long clientId, @Param("statut") String statut);
}