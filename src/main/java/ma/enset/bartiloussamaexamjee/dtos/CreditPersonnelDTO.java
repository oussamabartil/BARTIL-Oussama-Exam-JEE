package ma.enset.bartiloussamaexamjee.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreditPersonnelDTO extends CreditDTO {
    private String motif;

    public CreditPersonnelDTO() {
        super();
        this.setType("PERSONNEL");
    }
}