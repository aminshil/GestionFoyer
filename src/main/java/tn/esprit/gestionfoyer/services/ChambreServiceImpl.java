package tn.esprit.gestionfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.Etudiant;
import tn.esprit.gestionfoyer.entities.Reservation;
import tn.esprit.gestionfoyer.repository.IBlocRepository;
import tn.esprit.gestionfoyer.repository.IChambreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    IBlocRepository blocRepository;
   IChambreRepository chambreRepository;

    @Override
    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void removeChambre(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre findById(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    public Chambre addChambreToBloc(Chambre chambre, Long blocId) {
        Bloc bloc = blocRepository.findById(blocId)
                .orElseThrow(() -> new RuntimeException("Bloc not found"));
        chambre.setBloc(bloc);  // Set the Bloc object in Chambre
        return chambreRepository.save(chambre);  // Save the Chambre with the assigned Bloc
    }



}
