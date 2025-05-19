package ma.enset.bartiloussamaexamjee;

import ma.enset.bartiloussamaexamjee.entities.*;
import ma.enset.bartiloussamaexamjee.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class BartilOussamaExamJeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BartilOussamaExamJeeApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ClientRepository clientRepository,
                            CreditRepository creditRepository,
                            CreditPersonnelRepository creditPersonnelRepository,
                            CreditImmobilierRepository creditImmobilierRepository,
                            CreditProfessionnelRepository creditProfessionnelRepository,
                            RemboursementRepository remboursementRepository,
                            UserRepository userRepository,
                            RoleRepository roleRepository) {
        return args -> {
            // Création des rôles
            Stream.of("ROLE_CLIENT", "ROLE_EMPLOYE", "ROLE_ADMIN").forEach(r -> {
                Role role = new Role();
                role.setRoleName(r);
                roleRepository.save(role);
            });

            // Création des utilisateurs
            Stream.of("client1", "employe1", "admin1").forEach(u -> {
                User user = new User();
                user.setUsername(u);
                user.setPassword("1234");
                user.setActive(true);

                // Attribution des rôles
                if (u.contains("client")) {
                    user.getRoles().add(roleRepository.findByRoleName("ROLE_CLIENT"));
                } else if (u.contains("employe")) {
                    user.getRoles().add(roleRepository.findByRoleName("ROLE_EMPLOYE"));
                } else if (u.contains("admin")) {
                    user.getRoles().add(roleRepository.findByRoleName("ROLE_ADMIN"));
                }

                userRepository.save(user);
            });

            // Création des clients
            Client client1 = new Client();
            client1.setNom("Oussama BARTIL");
            client1.setEmail("oussamabartil@email.com");
            client1.setUser(userRepository.findByUsername("client1"));
            clientRepository.save(client1);

            Client client2 = new Client();
            client2.setNom("hassan bartikl");
            client2.setEmail("hassanbartil@email.com");
            clientRepository.save(client2);

            // Création des crédits personnels
            CreditPersonnel creditPersonnel = new CreditPersonnel();
            creditPersonnel.setClient(client1);
            creditPersonnel.setDateDemande(new Date());
            creditPersonnel.setStatut("En cours");
            creditPersonnel.setMontant(10000.0);
            creditPersonnel.setDureeRemboursement(24);
            creditPersonnel.setTauxInteret(2.5);
            creditPersonnel.setMotif("Achat voiture");
            creditPersonnelRepository.save(creditPersonnel);

            // Création des crédits immobiliers
            CreditImmobilier creditImmobilier = new CreditImmobilier();
            creditImmobilier.setClient(client1);
            creditImmobilier.setDateDemande(new Date());
            creditImmobilier.setStatut("Accepté");
            creditImmobilier.setDateAcception(new Date());
            creditImmobilier.setMontant(200000.0);
            creditImmobilier.setDureeRemboursement(240);
            creditImmobilier.setTauxInteret(1.8);
            creditImmobilier.setTypeBien("Appartement");
            creditImmobilierRepository.save(creditImmobilier);

            // Création des crédits professionnels
            CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
            creditProfessionnel.setClient(client2);
            creditProfessionnel.setDateDemande(new Date());
            creditProfessionnel.setStatut("En cours");
            creditProfessionnel.setMontant(50000.0);
            creditProfessionnel.setDureeRemboursement(60);
            creditProfessionnel.setTauxInteret(3.2);
            creditProfessionnel.setMotif("Expansion d'activité");
            creditProfessionnel.setRaisonSociale("Martin Consulting");
            creditProfessionnelRepository.save(creditProfessionnel);

            // Création des remboursements
            Remboursement remboursement1 = new Remboursement();
            remboursement1.setCredit(creditImmobilier);
            remboursement1.setDate(new Date());
            remboursement1.setMontant(800.0);
            remboursement1.setType("Mensualité");
            remboursementRepository.save(remboursement1);

            Remboursement remboursement2 = new Remboursement();
            remboursement2.setCredit(creditPersonnel);
            remboursement2.setDate(new Date());
            remboursement2.setMontant(450.0);
            remboursement2.setType("Mensualité");
            remboursementRepository.save(remboursement2);
        };
    }
}
