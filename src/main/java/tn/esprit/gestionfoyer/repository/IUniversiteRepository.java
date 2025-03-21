package tn.esprit.gestionfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Universite;

@Repository
public interface IUniversiteRepository extends JpaRepository<Universite, Long> {
    // Additional queries if needed
    Universite findByNomUniversite(String nomUniversite);
}
