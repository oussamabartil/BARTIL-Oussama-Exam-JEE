package ma.enset.bartiloussamaexamjee.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreditProfessionnelDTO extends CreditDTO {
    private String motif;
    private String raisonSociale;

    public CreditProfessionnelDTO() {
        super();
        this.setType("PROFESSIONNEL");
    }
}