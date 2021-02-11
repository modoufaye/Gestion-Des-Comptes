package org.sid.VotreBanque1.dao;
import org.sid.VotreBanque1.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, String>{
    
}
