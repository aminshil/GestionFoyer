package tn.esprit.gestionfoyer.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.entities.Universite;
import tn.esprit.gestionfoyer.repository.IFoyerRepository;
import tn.esprit.gestionfoyer.repository.IUniversiteRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {
    IFoyerRepository foyerRepository;
    IUniversiteRepository universiteRepository;

    @Override
    public List<Universite> findAll() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite findById(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite findByNom(String nom) {
        return universiteRepository.findByNomUniversite(nom);  // Calling the repository method to fetch by nom
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void removeUniversite(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    public Universite addUniversiteToFoyer(Universite universite, Long foyerId) {
        Foyer foyer = foyerRepository.findById(foyerId)
                .orElseThrow(() -> new RuntimeException("Foyer not found"));
        universite.setFoyer(foyer);  // Set the Foyer object in Universite
        return universiteRepository.save(universite);  // Save the Universite with the assigned Foyer
    }

    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new EntityNotFoundException("Foyer not found"));

        foyer.setUniversite(universite);
        foyerRepository.save(foyer);

        return universite;
    }

    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new EntityNotFoundException("Universite not found"));
        Foyer foyer = foyerRepository.findByUniversite(universite);

        if (foyer != null) {
            foyer.setUniversite(null);
            foyerRepository.save(foyer);
        }

        return universite;
    }



}
