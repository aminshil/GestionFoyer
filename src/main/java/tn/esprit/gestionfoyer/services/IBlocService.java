package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Bloc;
import java.util.List;

public interface IBlocService {
    List<Bloc> findAll();
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    void removeBloc(long idBloc);
    Bloc findById(long idBloc);
    Bloc assignBlocToFoyer(Bloc bloc, Long foyerId);
    Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);
}
