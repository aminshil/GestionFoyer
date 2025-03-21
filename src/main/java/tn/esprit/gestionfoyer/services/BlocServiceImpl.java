package tn.esprit.gestionfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.repository.IBlocRepository;
import tn.esprit.gestionfoyer.repository.IChambreRepository;
import tn.esprit.gestionfoyer.repository.IFoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
    IFoyerRepository foyerRepository;
    IBlocRepository blocRepository;
    IChambreRepository chambreRepository;
    @Override
    public List<Bloc> findAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc findById(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    // In BlocServiceImpl
    public Bloc addBlocToFoyer(Bloc bloc, Long foyerId) {
        Foyer foyer = foyerRepository.findById(foyerId)
                .orElseThrow(() -> new RuntimeException("Foyer not found"));
        bloc.setFoyer(foyer);  // Set the Foyer object in Bloc
        return blocRepository.save(bloc);  // Save the Bloc with the assigned Foyer
    }


    public Bloc assignBlocToFoyer(Bloc bloc, Long foyerId) {
        // Fetch the Foyer by ID. If not found, throw a custom exception
        Foyer foyer = foyerRepository.findById(foyerId)
                .orElseThrow(() -> new RuntimeException("Foyer with ID " + foyerId + " not found"));

        // Set the Foyer reference in the Bloc
        bloc.setFoyer(foyer);

        // Save and return the updated Bloc
        return blocRepository.save(bloc);
    }


    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc with ID " + idBloc + " not found"));

        List<Chambre> chambres = chambreRepository.findAllById(numChambre);

        if (chambres.size() != numChambre.size()) {
            throw new RuntimeException("One or more Chambres not found");
        }

        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);  // Set the reference of the Bloc in the Chambre entity
        }

        bloc.setChambres(chambres);  // Update the list of chambres in the Bloc

        blocRepository.save(bloc);
        return bloc;
    }


}
