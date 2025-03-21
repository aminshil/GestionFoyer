package tn.esprit.gestionfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.entities.Universite;

@Repository
public interface IFoyerRepository extends JpaRepository<Foyer, Long> {
    // specific thing to pull from db
    Foyer findByUniversite(Universite universite);

}