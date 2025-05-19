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
@DiscriminatorValue("IMMOBILIER")
public class CreditImmobilier extends Credit {
    private String typeBien; // Appartement, Maison, ou Local Commercial
}