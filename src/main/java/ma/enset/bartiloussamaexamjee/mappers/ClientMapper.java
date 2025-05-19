package ma.enset.bartiloussamaexamjee.mappers;

import ma.enset.bartiloussamaexamjee.dtos.ClientDTO;
import ma.enset.bartiloussamaexamjee.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "credits", ignore = true)
    @Mapping(target = "user", ignore = true)
    Client clientDTOToClient(ClientDTO clientDTO);

    ClientDTO clientToClientDTO(Client client);
}
