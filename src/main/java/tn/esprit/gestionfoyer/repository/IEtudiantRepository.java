package tn.esprit.gestionfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Etudiant;

import java.util.Optional;

@Repository
public interface IEtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByCin(long cin);

}