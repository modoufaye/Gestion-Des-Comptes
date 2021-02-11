package org.sid.VotreBanque1.entities;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("CC")
@Entity
public class CompteCourant extends Compte{
    private double decouvert;

    public CompteCourant() {
        super();
    }

    public CompteCourant(double decouvert, String codeCompte, Date dateCreation, double solde, Client client) {
        super(codeCompte, dateCreation, solde, client);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
    
}
