package ma.enset.bartiloussamaexamjee.mappers;

import ma.enset.bartiloussamaexamjee.dtos.CreditDTO;
import ma.enset.bartiloussamaexamjee.dtos.CreditImmobilierDTO;
import ma.enset.bartiloussamaexamjee.dtos.CreditPersonnelDTO;
import ma.enset.bartiloussamaexamjee.dtos.CreditProfessionnelDTO;
import ma.enset.bartiloussamaexamjee.entities.*;
import ma.enset.bartiloussamaexamjee.repositories.ClientRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public abstract class CreditMapper {

    @Autowired
    protected ClientRepository clientRepository;

    @Mapping(target = "client", ignore = true)
    @Mapping(target = "remboursements", ignore = true)
    public abstract Credit creditDTOToCredit(CreditDTO creditDTO);

    @Mapping(source = "client.id", target = "clientId")
    public abstract CreditDTO creditToCreditDTO(Credit credit);

    @Mapping(target = "client", source = "clientId", qualifiedByName = "idToClient")
    @Mapping(target = "remboursements", ignore = true)
    public abstract CreditPersonnel creditPersonnelDTOToCreditPersonnel(CreditPersonnelDTO dto);

    @Mapping(source = "client.id", target = "clientId")
    public abstract CreditPersonnelDTO creditPersonnelToCreditPersonnelDTO(CreditPersonnel creditPersonnel);

    @Mapping(target = "client", source = "clientId", qualifiedByName = "idToClient")
    @Mapping(target = "remboursements", ignore = true)
    public abstract CreditImmobilier creditImmobilierDTOToCreditImmobilier(CreditImmobilierDTO dto);

    @Mapping(source = "client.id", target = "clientId")
    public abstract CreditImmobilierDTO creditImmobilierToCreditImmobilierDTO(CreditImmobilier creditImmobilier);

    @Mapping(target = "client", source = "clientId", qualifiedByName = "idToClient")
    @Mapping(target = "remboursements", ignore = true)
    public abstract CreditProfessionnel creditProfessionnelDTOToCreditProfessionnel(CreditProfessionnelDTO dto);

    @Mapping(source = "client.id", target = "clientId")
    public abstract CreditProfessionnelDTO creditProfessionnelToCreditProfessionnelDTO(CreditProfessionnel creditProfessionnel);

    @Named("idToClient")
    Client idToClient(Long id) {
        if (id == null) return null;
        return clientRepository.findById(id).orElse(null);
    }
}