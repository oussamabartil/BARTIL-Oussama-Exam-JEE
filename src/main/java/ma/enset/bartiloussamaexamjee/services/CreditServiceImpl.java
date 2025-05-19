package ma.enset.bartiloussamaexamjee.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.bartiloussamaexamjee.dtos.CreditDTO;
import ma.enset.bartiloussamaexamjee.dtos.CreditImmobilierDTO;
import ma.enset.bartiloussamaexamjee.dtos.CreditPersonnelDTO;
import ma.enset.bartiloussamaexamjee.dtos.CreditProfessionnelDTO;
import ma.enset.bartiloussamaexamjee.entities.*;
import ma.enset.bartiloussamaexamjee.mappers.CreditMapper;
import ma.enset.bartiloussamaexamjee.repositories.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CreditServiceImpl implements CreditService {
    private final CreditRepository creditRepository;
    private final CreditPersonnelRepository creditPersonnelRepository;
    private final CreditImmobilierRepository creditImmobilierRepository;
    private final CreditProfessionnelRepository creditProfessionnelRepository;
    private final ClientRepository clientRepository;
    private final CreditMapper creditMapper;

    @Override
    public CreditDTO findById(Long id) {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit not found with id: " + id));
        return creditMapper.creditToCreditDTO(credit);
    }

    @Override
    public List<CreditDTO> findAll() {
        List<Credit> credits = creditRepository.findAll();
        return credits.stream()
                .map(creditMapper::creditToCreditDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        creditRepository.deleteById(id);
    }

    @Override
    public List<CreditDTO> findByClientId(Long clientId) {
        List<Credit> credits = creditRepository.findByClientId(clientId);
        return credits.stream()
                .map(creditMapper::creditToCreditDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditDTO> findByStatut(String statut) {
        List<Credit> credits = creditRepository.findByStatut(statut);
        return credits.stream()
                .map(creditMapper::creditToCreditDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CreditPersonnelDTO savePersonnel(CreditPersonnelDTO creditDTO) {
        creditDTO.setDateDemande(new Date()); // Date actuelle
        creditDTO.setStatut("En cours"); // Statut par défaut

        Client client = clientRepository.findById(creditDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + creditDTO.getClientId()));

        CreditPersonnel creditPersonnel = creditMapper.creditPersonnelDTOToCreditPersonnel(creditDTO);
        creditPersonnel.setClient(client);

        CreditPersonnel savedCredit = creditPersonnelRepository.save(creditPersonnel);
        return creditMapper.creditPersonnelToCreditPersonnelDTO(savedCredit);
    }

    @Override
    public CreditPersonnelDTO updatePersonnel(CreditPersonnelDTO creditDTO) {
        CreditPersonnel creditPersonnel = creditMapper.creditPersonnelDTOToCreditPersonnel(creditDTO);
        CreditPersonnel updatedCredit = creditPersonnelRepository.save(creditPersonnel);
        return creditMapper.creditPersonnelToCreditPersonnelDTO(updatedCredit);
    }

    @Override
    public List<CreditPersonnelDTO> findPersonnelByMotif(String motif) {
        List<CreditPersonnel> credits = creditPersonnelRepository.findByMotif(motif);
        return credits.stream()
                .map(creditMapper::creditPersonnelToCreditPersonnelDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CreditImmobilierDTO saveImmobilier(CreditImmobilierDTO creditDTO) {
        creditDTO.setDateDemande(new Date()); // Date actuelle
        creditDTO.setStatut("En cours"); // Statut par défaut

        Client client = clientRepository.findById(creditDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + creditDTO.getClientId()));

        CreditImmobilier creditImmobilier = creditMapper.creditImmobilierDTOToCreditImmobilier(creditDTO);
        creditImmobilier.setClient(client);

        CreditImmobilier savedCredit = creditImmobilierRepository.save(creditImmobilier);
        return creditMapper.creditImmobilierToCreditImmobilierDTO(savedCredit);
    }

    @Override
    public CreditImmobilierDTO updateImmobilier(CreditImmobilierDTO creditDTO) {
        CreditImmobilier creditImmobilier = creditMapper.creditImmobilierDTOToCreditImmobilier(creditDTO);
        CreditImmobilier updatedCredit = creditImmobilierRepository.save(creditImmobilier);
        return creditMapper.creditImmobilierToCreditImmobilierDTO(updatedCredit);
    }

    @Override
    public List<CreditImmobilierDTO> findImmobilierByTypeBien(String typeBien) {
        List<CreditImmobilier> credits = creditImmobilierRepository.findByTypeBien(typeBien);
        return credits.stream()
                .map(creditMapper::creditImmobilierToCreditImmobilierDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CreditProfessionnelDTO saveProfessionnel(CreditProfessionnelDTO creditDTO) {
        creditDTO.setDateDemande(new Date()); // Date actuelle
        creditDTO.setStatut("En cours"); // Statut par défaut

        Client client = clientRepository.findById(creditDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + creditDTO.getClientId()));

        CreditProfessionnel creditProfessionnel = creditMapper.creditProfessionnelDTOToCreditProfessionnel(creditDTO);
        creditProfessionnel.setClient(client);

        CreditProfessionnel savedCredit = creditProfessionnelRepository.save(creditProfessionnel);
        return creditMapper.creditProfessionnelToCreditProfessionnelDTO(savedCredit);
    }

    @Override
    public CreditProfessionnelDTO updateProfessionnel(CreditProfessionnelDTO creditDTO) {
        CreditProfessionnel creditProfessionnel = creditMapper.creditProfessionnelDTOToCreditProfessionnel(creditDTO);
        CreditProfessionnel updatedCredit = creditProfessionnelRepository.save(creditProfessionnel);
        return creditMapper.creditProfessionnelToCreditProfessionnelDTO(updatedCredit);
    }

    @Override
    public List<CreditProfessionnelDTO> findProfessionnelByRaisonSociale(String raisonSociale) {
        List<CreditProfessionnel> credits = creditProfessionnelRepository.findByRaisonSociale(raisonSociale);
        return credits.stream()
                .map(creditMapper::creditProfessionnelToCreditProfessionnelDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CreditDTO changeStatut(Long creditId, String statut) {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new RuntimeException("Credit not found with id: " + creditId));

        credit.setStatut(statut);
        if ("Accepté".equals(statut)) {
            credit.setDateAcception(new Date());
        }

        Credit updatedCredit = creditRepository.save(credit);
        return creditMapper.creditToCreditDTO(updatedCredit);
    }
}