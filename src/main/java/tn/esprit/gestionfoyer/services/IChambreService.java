package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.Etudiant;

import java.util.List;

public interface IChambreService {
    List<Chambre> findAll();
    Chambre addChambre(Chambre chambre);
    Chambre updateChambre(Chambre chambre);
    void removeChambre(long idChambre);
    Chambre findById(long idChambre);
}
