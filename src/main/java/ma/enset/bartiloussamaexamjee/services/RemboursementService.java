package ma.enset.bartiloussamaexamjee.services;


import ma.enset.bartiloussamaexamjee.dtos.RemboursementDTO;

import java.util.Date;
import java.util.List;

public interface RemboursementService {
    RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO);
    RemboursementDTO getRemboursementById(Long id);
    List<RemboursementDTO> getAllRemboursements();
    RemboursementDTO updateRemboursement(RemboursementDTO remboursementDTO);
    void deleteRemboursement(Long id);
    List<RemboursementDTO> getRemboursementsByCreditId(Long creditId);
}