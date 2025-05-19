package ma.enset.bartiloussamaexamjee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CREDIT", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class Credit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateDemande;
    private String statut; // En cours, Accepté, rejeté
    private Date dateAcception;
    private Double montant;
    private Integer dureeRemboursement;
    private Double tauxInteret;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "credit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Remboursement> remboursements;
}