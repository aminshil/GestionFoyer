package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Universite;
import java.util.List;

public interface IUniversiteService {
    List<Universite> findAll();
    Universite findById(long idUniversite);
    Universite findByNom(String nom);
    Universite addUniversite(Universite u);
    Universite updateUniversite(Universite u);
    void removeUniversite(long idUniversite);
    Universite affecterFoyerAUniversite(long foyerId, String nomUniversite);
    Universite desaffecterFoyerAUniversite(long idUniversite);
}