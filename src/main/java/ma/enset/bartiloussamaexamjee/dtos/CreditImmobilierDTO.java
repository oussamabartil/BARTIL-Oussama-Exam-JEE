package ma.enset.bartiloussamaexamjee.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreditImmobilierDTO extends CreditDTO {
    private String typeBien;

    public CreditImmobilierDTO() {
        super();
        this.setType("IMMOBILIER");
    }
}