package org.sid.VotreBanque1.entities;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@DiscriminatorValue("CE")
@Entity
public class CompteEpargne extends Compte{
    private double taux;

    public CompteEpargne() {
        super();
    }

    public CompteEpargne(double taux, String codeCompte, Date dateCreation, double solde, Client client) {
        super(codeCompte, dateCreation, solde, client);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
    
}
