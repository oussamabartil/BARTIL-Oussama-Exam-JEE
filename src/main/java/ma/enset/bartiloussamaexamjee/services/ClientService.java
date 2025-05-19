package ma.enset.bartiloussamaexamjee.services;

import ma.enset.bartiloussamaexamjee.dtos.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO save(ClientDTO clientDTO);
    ClientDTO update(ClientDTO clientDTO);
    void delete(Long id);
    ClientDTO findById(Long id);
    List<ClientDTO> findAll();
    ClientDTO findByEmail(String email);
}