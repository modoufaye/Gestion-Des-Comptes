package org.sid.VotreBanque1.entities;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@DiscriminatorValue("V")
@Entity
public class Versement extends Operation{

    public Versement() {
        super();
    }

    public Versement(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
    
}
