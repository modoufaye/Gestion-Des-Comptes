package org.sid.VotreBanque1.metier;

import java.util.Date;
import java.util.Optional;
import org.sid.VotreBanque1.dao.CompteRepository;
import org.sid.VotreBanque1.dao.OperationRepository;
import org.sid.VotreBanque1.entities.Compte;
import org.sid.VotreBanque1.entities.CompteCourant;
import org.sid.VotreBanque1.entities.Operation;
import org.sid.VotreBanque1.entities.Retrait;
import org.sid.VotreBanque1.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BanqueMetierImpl implements IBanqueMetier{
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Compte consulterCompte(String codeCompte) {
        Optional <Compte> cp = compteRepository.findById(codeCompte);
        if(cp.get()==null) 
            throw new RuntimeException("Compte introuvable");
        return cp.get();
    }

    @Override
    public void verser(String codecompte, double montant) {
        Compte cp = consulterCompte(codecompte);
        Versement v = new Versement(new Date(), montant, cp);
        operationRepository.save(v);
        cp.setSolde(montant+cp.getSolde());
        compteRepository.save(cp);
    }

    @Override
    public void retirer(String codecompte, double montant) {
        Compte cp = consulterCompte(codecompte);
        double facilite = 0;
        if(cp instanceof CompteCourant)
            facilite = ((CompteCourant)cp).getDecouvert();
        if(facilite + cp.getSolde()<montant)
            throw new RuntimeException("Solde insuffisant");
        Retrait r = new Retrait(new Date(), montant, cp);
        operationRepository.save(r);
        cp.setSolde(cp.getSolde()-montant);
        compteRepository.save(cp);
        
    }

    @Override
    public void virement(String codecompte1, String codecompte2, double montant) {
        if(codecompte1.equals(codecompte2))
            throw new RuntimeException("Impossible d'effectuer un virement sur le meme compte");
        retirer(codecompte1, montant);
        verser(codecompte2, montant);
    }

    @Override
    public Page<Operation> listOperation(String codeCompte, int page, int size) {
        return operationRepository.listOperation(codeCompte, PageRequest.of(page,size));
    }
    
}
