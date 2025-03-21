package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Etudiant;
import java.util.List;

public interface IEtudiantService {
    List<Etudiant> findAll();
    Etudiant addEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Etudiant etudiant);
    void removeEtudiant(long idEtudiant);
    Etudiant findById(long idEtudiant);
}
