package ma.enset.bartiloussamaexamjee.web;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import ma.enset.bartiloussamaexamjee.dtos.ClientDTO;
import ma.enset.bartiloussamaexamjee.dtos.CreditDTO;
import ma.enset.bartiloussamaexamjee.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
//@RestController
//@RequestMapping("/api/clients")
//@RequiredArgsConstructor
//@Tag(name = "Client API", description = "API pour la gestion des clients")
//@CrossOrigin("*")
//public class ClientController {
//
//    private final ClientService clientService;
//
//    @GetMapping
//    @Operation(summary = "Récupérer tous les clients")
//    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE')")
//    public ResponseEntity<List<ClientDTO>> getAllClients() {
//        return ResponseEntity.ok(clientService.findAll());
//    }
//
//    @GetMapping("/{id}")
//    @Operation(summary = "Récupérer un client par son ID")
//   // @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE') or @securityService.isCurrentUser(#username)")
//    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
//        return ResponseEntity.ok(clientService.findById(id));
//    }
//
//    @PostMapping
//    @Operation(summary = "Créer un nouveau client")
//    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE')")
//    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
//        return new ResponseEntity<>(clientService.save(clientDTO), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    @Operation(summary = "Mettre à jour un client")
//    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE')")
//    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
//        clientDTO.setId(id);
//        return ResponseEntity.ok(clientService.update(clientDTO));
//    }
//
//    @DeleteMapping("/{id}")
//    @Operation(summary = "Supprimer un client")
//   // @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
//        clientService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
////
////    @GetMapping("/search")
////    @Operation(summary = "Rechercher des clients par mot-clé")
////   // @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE')")
////    public ResponseEntity<List<ClientDTO>> searchClients(@RequestParam String keyword) {
////        return ResponseEntity.ok(clientService.search(keyword));
////    }
//}


import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping
    public ClientDTO addClient(@RequestBody ClientDTO clientDTO) {
        return clientService.save(clientDTO);
    }

    @PutMapping
    public ClientDTO updateClient(@RequestBody ClientDTO clientDTO) {
        return clientService.update(clientDTO);
    }

//    @DeleteMapping("/{id}")
//    public void deleteClient(@PathVariable Long id) {
//        clientService.de(id);
//    }

//    @GetMapping("/{clientId}/credits")
//    public List<CreditDTO> getClientCredits(@PathVariable Long clientId) {
//        return clientService.(clientId);
//    }
}