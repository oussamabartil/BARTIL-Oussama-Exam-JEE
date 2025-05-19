package ma.enset.bartiloussamaexamjee.dtos;


import lombok.Data;

import java.util.Date;

@Data
public class CreditDTO {
    private Long id;
    private Date dateDemande;
    private String statut;
    private Date dateAcception;
    private Double montant;
    private Integer dureeRemboursement;
    private Double tauxInteret;
    private Long clientId;

    // Discriminator field
    private String type;
}