package tn.esprit.gestionfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Bloc;

@Repository
public interface IBlocRepository extends JpaRepository<Bloc, Long> {
}
