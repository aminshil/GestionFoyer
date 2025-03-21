package tn.esprit.gestionfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.entities.Universite;
import tn.esprit.gestionfoyer.repository.IChambreRepository;
import tn.esprit.gestionfoyer.repository.IFoyerRepository;
import tn.esprit.gestionfoyer.repository.IUniversiteRepository;

import java.util.List;

@Service  // ✅ This annotation makes it a Spring-managed bean
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerServices {

    IFoyerRepository foyerRepository;
    IChambreRepository chambreRepository;
    IUniversiteRepository universiteRepository;
    @Override
    public List<Foyer> findALL() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);  // ✅ Implement repository method
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);  // ✅ Implement repository method
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);  // ✅ Implement repository method
    }

    @Override
    public Foyer findById(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);  // ✅ Implement repository method
    }


    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Universite with ID " + idUniversite + " not found"));

        // Ensure the university does not already have a foyer (to maintain One-to-One)
        if (universite.getFoyer() != null) {
            throw new RuntimeException("This Universite already has a Foyer.");
        }

        foyer.setUniversite(universite);
        universite.setFoyer(foyer); // Correct way to assign a One-to-One relationship

        // Save the Foyer and update Universite
        foyerRepository.save(foyer);
        universiteRepository.save(universite);

        return foyer;
    }




}
