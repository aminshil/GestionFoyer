package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Foyer;
import java.util.List;
import java.util.Optional;


public interface IFoyerServices {
    public List<Foyer> findALL();
    Foyer addFoyer(Foyer f);
    Foyer updateFoyer(Foyer f);
    void removeFoyer(long idFoyer);
    public Foyer findById(long idFoyer);
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}