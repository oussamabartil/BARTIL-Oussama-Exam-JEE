package ma.enset.bartiloussamaexamjee.services;
import lombok.RequiredArgsConstructor;
import ma.enset.bartiloussamaexamjee.dtos.RemboursementDTO;
import ma.enset.bartiloussamaexamjee.entities.Credit;
import ma.enset.bartiloussamaexamjee.entities.Remboursement;
import ma.enset.bartiloussamaexamjee.mappers.RemboursementMapper;
import ma.enset.bartiloussamaexamjee.repositories.CreditRepository;
import ma.enset.bartiloussamaexamjee.repositories.RemboursementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RemboursementServiceImpl implements RemboursementService {

    private final RemboursementRepository remboursementRepository;
    private final CreditRepository creditRepository;
    private final RemboursementMapper remboursementMapper;

    @Override
    public RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO) {
        Remboursement remboursement = remboursementMapper.remboursementDTOToRemboursement(remboursementDTO);

        // Récupérer le crédit associé
        if (remboursementDTO.getCreditId() != null) {
            Credit credit = creditRepository.findById(remboursementDTO.getCreditId())
                    .orElseThrow(() -> new RuntimeException("Credit not found with id: " + remboursementDTO.getCreditId()));
            remboursement.setCredit(credit);
        }

        Remboursement savedRemboursement = remboursementRepository.save(remboursement);
        return remboursementMapper.remboursementToRemboursementDTO(savedRemboursement);
    }

    @Override
    public RemboursementDTO getRemboursementById(Long id) {
        Remboursement remboursement = remboursementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remboursement not found with id: " + id));
        return remboursementMapper.remboursementToRemboursementDTO(remboursement);
    }

    @Override
    public List<RemboursementDTO> getAllRemboursements() {
        List<Remboursement> remboursements = remboursementRepository.findAll();
        return remboursementMapper.remboursementsToRemboursementDTOs(remboursements);
    }

    @Override
    public RemboursementDTO updateRemboursement(RemboursementDTO remboursementDTO) {
        Remboursement existingRemboursement = remboursementRepository.findById(remboursementDTO.getId())
                .orElseThrow(() -> new RuntimeException("Remboursement not found with id: " + remboursementDTO.getId()));

        // Mise à jour des propriétés
        existingRemboursement.setDate(remboursementDTO.getDate());
        existingRemboursement.setMontant(remboursementDTO.getMontant());
        existingRemboursement.setType(remboursementDTO.getType());

        // Mise à jour du crédit associé si nécessaire
        if (remboursementDTO.getCreditId() != null) {
            Credit credit = creditRepository.findById(remboursementDTO.getCreditId())
                    .orElseThrow(() -> new RuntimeException("Credit not found with id: " + remboursementDTO.getCreditId()));
            existingRemboursement.setCredit(credit);
        }

        Remboursement updatedRemboursement = remboursementRepository.save(existingRemboursement);
        return remboursementMapper.remboursementToRemboursementDTO(updatedRemboursement);
    }

    @Override
    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }

    @Override
    public List<RemboursementDTO> getRemboursementsByCreditId(Long creditId) {
        List<Remboursement> remboursements = remboursementRepository.findByCreditId(creditId);
        return remboursementMapper.remboursementsToRemboursementDTOs(remboursements);
    }
}