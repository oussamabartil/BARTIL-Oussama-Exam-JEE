package ma.enset.bartiloussamaexamjee.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PERSONNEL")
public class CreditPersonnel extends Credit {
    private String motif; // achat de voiture, études, travaux
}