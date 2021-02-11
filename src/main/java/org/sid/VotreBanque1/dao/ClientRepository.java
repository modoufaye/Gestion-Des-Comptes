package org.sid.VotreBanque1.dao;
import org.sid.VotreBanque1.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
