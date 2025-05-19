package ma.enset.bartiloussamaexamjee.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.bartiloussamaexamjee.dtos.ClientDTO;
import ma.enset.bartiloussamaexamjee.entities.Client;
import ma.enset.bartiloussamaexamjee.mappers.ClientMapper;
import ma.enset.bartiloussamaexamjee.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Client client = clientMapper.clientDTOToClient(clientDTO);
        Client savedClient = clientRepository.save(client);
        return clientMapper.clientToClientDTO(savedClient);
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) {
        Client client = clientMapper.clientDTOToClient(clientDTO);
        Client updatedClient = clientRepository.save(client);
        return clientMapper.clientToClientDTO(updatedClient);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Client not found with id: " + id));
        return clientMapper.clientToClientDTO(client);
    }

    @Override
    public List<ClientDTO> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::clientToClientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO findByEmail(String email) {
        Client client = clientRepository.findByEmail(email);
        if (client == null) {
            throw new RuntimeException("Client not found with email: " + email);
        }
        return clientMapper.clientToClientDTO(client);
    }
}