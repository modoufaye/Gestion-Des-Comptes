package org.sid.VotreBanque1;

import java.util.Date;
import org.sid.VotreBanque1.dao.ClientRepository;
import org.sid.VotreBanque1.dao.CompteRepository;
import org.sid.VotreBanque1.dao.OperationRepository;
import org.sid.VotreBanque1.entities.Client;
import org.sid.VotreBanque1.entities.Compte;
import org.sid.VotreBanque1.entities.CompteCourant;
import org.sid.VotreBanque1.entities.CompteEpargne;
import org.sid.VotreBanque1.entities.Retrait;
import org.sid.VotreBanque1.entities.Versement;
import org.sid.VotreBanque1.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VotreBanque1Application implements CommandLineRunner{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private IBanqueMetier banqueMetier;
	public static void main(String[] args) {
		SpringApplication.run(VotreBanque1Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Client c1 = clientRepository.save(new Client("Mor", "morseck@gmail.com"));
        Client c2 = clientRepository.save(new Client("Mariama", "mariamatoure@gmail.com"));
        Client c3 = clientRepository.save(new Client("Fallou", "falloufaye@gmail.com"));
        
        Compte cp1 = compteRepository.save(new CompteEpargne(6.5, "ce1", new Date(), 25000, c1));
        Compte cp2 = compteRepository.save(new CompteCourant(1500, "cc1", new Date(), 45000, c1));
        
        Compte cp3 = compteRepository.save(new CompteEpargne(3, "ce2", new Date(), 50000, c2));
        Compte cp4 = compteRepository.save(new CompteCourant(5300, "cc2", new Date(), 75000, c2));
        
        Compte cp5 = compteRepository.save(new CompteEpargne(8.5, "ce3", new Date(), 75000, c3));
        Compte cp6 = compteRepository.save(new CompteCourant(1500, "cc3", new Date(), 95000, c3));
        
        operationRepository.save(new Versement(new Date(),15000 , cp1));
        operationRepository.save(new Versement(new Date(),7000 , cp1));
        operationRepository.save(new Versement(new Date(),65000 , cp1));
        operationRepository.save(new Versement(new Date(),33500 , cp1));
        operationRepository.save(new Versement(new Date(),15000 , cp1));
        operationRepository.save(new Versement(new Date(),7000 , cp1));
        operationRepository.save(new Versement(new Date(),65000 , cp1));
        operationRepository.save(new Versement(new Date(),33500 , cp1));
        
        operationRepository.save(new Versement(new Date(),23000 , cp2));
        operationRepository.save(new Versement(new Date(),6750 , cp2));
        operationRepository.save(new Retrait(new Date(), 7400, cp2));
        operationRepository.save(new Versement(new Date(),23000 , cp2));
        operationRepository.save(new Versement(new Date(),6750 , cp2));
        operationRepository.save(new Retrait(new Date(), 7400, cp2));
        
        operationRepository.save(new Versement(new Date(),23000 , cp3));
        operationRepository.save(new Versement(new Date(),6750 , cp3));
                
        operationRepository.save(new Versement(new Date(),53000 , cp4));
        operationRepository.save(new Versement(new Date(),28050 , cp4));
        operationRepository.save(new Retrait(new Date(), 14700, cp4));
        operationRepository.save(new Versement(new Date(),23000 , cp3));
        operationRepository.save(new Versement(new Date(),6750 , cp3));
                
        operationRepository.save(new Versement(new Date(),53000 , cp4));
        operationRepository.save(new Versement(new Date(),28050 , cp4));
        operationRepository.save(new Retrait(new Date(), 14700, cp4));
        
        operationRepository.save(new Versement(new Date(),23000 , cp5));
        operationRepository.save(new Versement(new Date(),6750 , cp5));
                
        operationRepository.save(new Versement(new Date(),53000 , cp6));
        operationRepository.save(new Versement(new Date(),28050 , cp6));
        operationRepository.save(new Retrait(new Date(), 14700, cp6));
        
         operationRepository.save(new Versement(new Date(),23000 , cp5));
        operationRepository.save(new Versement(new Date(),6750 , cp5));
                
        operationRepository.save(new Versement(new Date(),53000 , cp6));
        operationRepository.save(new Versement(new Date(),28050 , cp6));
        operationRepository.save(new Retrait(new Date(), 14700, cp6));
        banqueMetier.verser("ce1", 11111);
        banqueMetier.verser("ce2", 220000);
    }

}
