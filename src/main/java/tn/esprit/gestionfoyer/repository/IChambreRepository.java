package tn.esprit.gestionfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.entities.Chambre;

import java.util.List;

@Repository
public interface IChambreRepository extends JpaRepository<Chambre, Long> {
    //List<Chambre> findByBlocIdAndDisponibilite(Long blocId, boolean disponibilite);
    List<Chambre> findByBloc(Bloc bloc); // Add this method

}
