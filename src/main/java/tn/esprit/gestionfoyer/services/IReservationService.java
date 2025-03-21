package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Reservation;
import java.util.List;

public interface IReservationService {
    List<Reservation> findAll();
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void removeReservation(long idReservation);
    Reservation findById(long idReservation);
    Reservation ajouterReservation(long idBloc, long cinEtudiant);

}
