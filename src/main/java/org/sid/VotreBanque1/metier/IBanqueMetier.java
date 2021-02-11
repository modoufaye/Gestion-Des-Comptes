package org.sid.VotreBanque1.metier;

import org.sid.VotreBanque1.entities.Compte;
import org.sid.VotreBanque1.entities.Operation;
import org.springframework.data.domain.Page;

public interface IBanqueMetier {
    public Compte consulterCompte(String codeCompte);
    public void verser(String codecompte, double montant);
    public void retirer(String codecompte, double montant);
    public void virement(String codecompte1,String codecompte2, double montant);
    public Page<Operation> listOperation(String codeCompte, int page, int size);
}
