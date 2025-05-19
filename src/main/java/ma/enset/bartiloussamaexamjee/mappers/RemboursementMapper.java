package ma.enset.bartiloussamaexamjee.mappers;

import ma.enset.bartiloussamaexamjee.dtos.RemboursementDTO;
import ma.enset.bartiloussamaexamjee.entities.Credit;
import ma.enset.bartiloussamaexamjee.entities.Remboursement;
import ma.enset.bartiloussamaexamjee.repositories.CreditRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class RemboursementMapper {

    @Autowired
    protected CreditRepository creditRepository;

    @Mapping(target = "credit", source = "creditId", qualifiedByName = "idToCredit")
    public abstract Remboursement remboursementDTOToRemboursement(RemboursementDTO dto);

    @Mapping(source = "credit.id", target = "creditId")
    public abstract RemboursementDTO remboursementToRemboursementDTO(Remboursement remboursement);

    @Named("idToCredit")
    Credit idToCredit(Long id) {
        if (id == null) return null;
        return creditRepository.findById(id).orElse(null);
    }
}