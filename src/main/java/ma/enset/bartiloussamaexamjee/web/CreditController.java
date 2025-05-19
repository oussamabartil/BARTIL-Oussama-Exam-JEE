    package ma.enset.bartiloussamaexamjee.web;

    import io.swagger.v3.oas.annotations.Operation;
    import io.swagger.v3.oas.annotations.tags.Tag;
    import lombok.RequiredArgsConstructor;
    import ma.enset.bartiloussamaexamjee.dtos.CreditDTO;
    import ma.enset.bartiloussamaexamjee.dtos.CreditImmobilierDTO;
    import ma.enset.bartiloussamaexamjee.dtos.CreditPersonnelDTO;
    import ma.enset.bartiloussamaexamjee.services.CreditService;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    //import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
//
//    @RestController
//    @RequestMapping("/api/credits")
//    @RequiredArgsConstructor
//    @Tag(name = "Credit API", description = "API pour la gestion des crédits")
//    @CrossOrigin("*")
//    public class CreditController {
//
//        private final CreditService creditService;
//
//        // Méthodes génériques pour tous les crédits
//        @GetMapping
//        @Operation(summary = "Récupérer tous les crédits")
//        //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE')")
//        public ResponseEntity<List<CreditDTO>> getAllCredits() {
//            return ResponseEntity.ok(creditService.findAll());
//        }
//
//        @GetMapping("/{id}")
//        @Operation(summary = "Récupérer un crédit par son ID")
//        //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE', 'CLIENT')")
//        public ResponseEntity<CreditDTO> getCreditById(@PathVariable Long id) {
//            return ResponseEntity.ok(creditService.findById(id));
//        }
//
//        @DeleteMapping("/{id}")
//        @Operation(summary = "Supprimer un crédit")
//        // @PreAuthorize("hasRole('ADMIN')")
//        public ResponseEntity<Void> deleteCredit(@PathVariable Long id) {
//            creditService.delete(id);
//            return ResponseEntity.noContent().build();
//        }
//
//        @GetMapping("/client/{clientId}")
//        @Operation(summary = "Récupérer les crédits d'un client")
//        //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE') or @securityService.isClientOwner(#clientId)")
//        public ResponseEntity<List<CreditDTO>> getCreditsByClientId(@PathVariable Long clientId) {
//            return ResponseEntity.ok(creditService.findByClientId(clientId));
//        }
//
//        @GetMapping("/status/{status}")
//        @Operation(summary = "Récupérer les crédits par statut")
//        //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE')")
//        public ResponseEntity<List<CreditDTO>> getCreditsByStatus(@PathVariable String status) {
//            return ResponseEntity.ok(creditService.findByStatut(status));
//        }
//
//        // Méthodes pour CreditPersonnel
//    //    @GetMapping("/personnel")
//    //    @Operation(summary = "Récupérer tous les crédits personnels")
//    ////    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE')")
//    //    public ResponseEntity<List<CreditPersonnelDTO>> getAllCreditsPersonnel() {
//    //        return ResponseEntity.ok(creditService.fi());
//    //    }
//
//        @PostMapping("/personnel")
//        @Operation(summary = "Créer un nouveau crédit personnel")
//        //  @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE')")
//        public ResponseEntity<CreditPersonnelDTO> createCreditPersonnel(@RequestBody CreditPersonnelDTO creditDTO) {
//            return new ResponseEntity<>(creditService.savePersonnel(creditDTO), HttpStatus.CREATED);
//        }
//
//        @PutMapping("/personnel/{id}")
//        @Operation(summary = "Mettre à jour un crédit personnel")
//        // @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE')")
//        public ResponseEntity<CreditPersonnelDTO> updateCreditPersonnel(@PathVariable Long id, @RequestBody CreditPersonnelDTO creditDTO) {
//            creditDTO.setId(id);
//            return ResponseEntity.ok(creditService.updatePersonnel(creditDTO));
//        }
//
//        // Méthodes pour CreditImmobilier
//    //    @GetMapping("/immobilier")
//    //    @Operation(summary = "Récupérer tous les crédits immobiliers")
//    //    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE')")
//    //    public ResponseEntity<List<CreditImmobilierDTO>> getAllCreditsImmobilier() {
//    //        return ResponseEntity.ok(creditService.fin());
//    //    }
//
//        @PostMapping("/immobilier")
//        @Operation(summary = "Créer un nouveau crédit immobilier")
//        //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE')")
//        public ResponseEntity<CreditImmobilierDTO> createCreditImmobilier(@RequestBody CreditImmobilierDTO creditDTO) {
//            return new ResponseEntity<>(creditService.saveImmobilier(creditDTO), HttpStatus.CREATED);
//        }
//
//        @PutMapping("/immobilier/{id}")
//        @Operation(summary = "Mettre à jour un crédit immobilier")
//        //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYE')")
//        public ResponseEntity<CreditImmobilierDTO> updateCreditImmobilier(@PathVariable Long id, @RequestBody CreditImmobilierDTO creditDTO) {
//            creditDTO.setId(id);
//            return ResponseEntity.ok(creditService.updateImmobilier(creditDTO));
//        }
//    }


    @RestController
    @RequestMapping("/api/credits")
    @RequiredArgsConstructor
    @CrossOrigin("*")
    public class CreditController {

        private final CreditService creditService;

        @GetMapping
        public List<CreditDTO> getAllCredits() {
            return creditService.findAll();
        }

        @GetMapping("/{id}")
        public CreditDTO getCreditById(@PathVariable Long id) {
            return creditService.findById(id);
        }

//        @GetMapping("/client/{clientId}")
//        public CreditDTO getCreditByClientId(@PathVariable Long clientId) {
//            return creditService.findByClientId(clientId);
//        }
//
//        @PostMapping("/immobilier/{clientId}")
//        public CreditDTO addImmobilierCredit(@RequestBody CreditImmobilierDTO creditDTO, @PathVariable Long clientId) {
////            return new ResponseEntity<>(creditService.saveImmobilier(creditDTO), HttpStatus.CREATED);
//        }
//
//        @PostMapping("/personnel/{clientId}")
//        public CreditDTO addPersonnelCredit(@RequestBody CreditPersonnelDTO creditDTO, @PathVariable Long clientId) {
//            return creditService.addCreditPersonnel(creditDTO, clientId);
//        }
//
//        @PostMapping("/professionnel/{clientId}")
//        public CreditDTO addProfessionnelCredit(@RequestBody CreditProfessionnelDTO creditDTO, @PathVariable Long clientId) {
//            return creditService.addCreditProfessionnel(creditDTO, clientId);
//        }
//
//        @DeleteMapping("/{id}")
//        public void deleteCredit(@PathVariable Long id) {
//            creditService.deleteCredit(id);
//        }
//
//        @GetMapping("/{creditId}/remboursements")
//        public List<RemboursementDTO> getCreditRemboursements(@PathVariable Long creditId) {
//            return creditService.getCreditRemboursements(creditId);
//        }
    }