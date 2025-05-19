package ma.enset.bartiloussamaexamjee.services;

import ma.enset.bartiloussamaexamjee.dtos.CreditDTO;
import ma.enset.bartiloussamaexamjee.dtos.CreditImmobilierDTO;
import ma.enset.bartiloussamaexamjee.dtos.CreditPersonnelDTO;
import ma.enset.bartiloussamaexamjee.dtos.CreditProfessionnelDTO;

import java.util.List;

public interface CreditService {
    // Méthodes génériques pour tous les crédits
    CreditDTO findById(Long id);
    List<CreditDTO> findAll();
    void delete(Long id);
    List<CreditDTO> findByClientId(Long clientId);
    List<CreditDTO> findByStatut(String statut);

    // Méthodes spécifiques aux crédits personnels
    CreditPersonnelDTO savePersonnel(CreditPersonnelDTO creditDTO);
    CreditPersonnelDTO updatePersonnel(CreditPersonnelDTO creditDTO);
    List<CreditPersonnelDTO> findPersonnelByMotif(String motif);

    // Méthodes spécifiques aux crédits immobiliers
    CreditImmobilierDTO saveImmobilier(CreditImmobilierDTO creditDTO);
    CreditImmobilierDTO updateImmobilier(CreditImmobilierDTO creditDTO);
    List<CreditImmobilierDTO> findImmobilierByTypeBien(String typeBien);

    // Méthodes spécifiques aux crédits professionnels
    CreditProfessionnelDTO saveProfessionnel(CreditProfessionnelDTO creditDTO);
    CreditProfessionnelDTO updateProfessionnel(CreditProfessionnelDTO creditDTO);
    List<CreditProfessionnelDTO> findProfessionnelByRaisonSociale(String raisonSociale);

    // Méthode pour changer le statut d'un crédit
    CreditDTO changeStatut(Long creditId, String statut);
}