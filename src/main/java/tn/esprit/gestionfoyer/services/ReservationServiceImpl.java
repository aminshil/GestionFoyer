package tn.esprit.gestionfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.*;
import tn.esprit.gestionfoyer.repository.IBlocRepository;
import tn.esprit.gestionfoyer.repository.IChambreRepository;
import tn.esprit.gestionfoyer.repository.IEtudiantRepository;
import tn.esprit.gestionfoyer.repository.IReservationRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    IChambreRepository chambreRepository;
    IEtudiantRepository etudiantRepository;
   IReservationRepository reservationRepository;
   IBlocRepository blocRepository;

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void removeReservation(long idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation findById(long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    public Reservation addReservationToChambre(Reservation reservation, Long chambreId, List<Long> etudiantIds) {
        Chambre chambre = chambreRepository.findById(chambreId)
                .orElseThrow(() -> new RuntimeException("Chambre not found"));
        reservation.setChambre(chambre);  // Set the Chambre in Reservation

        // Optionally, set the Etudiants to the Reservation
        List<Etudiant> etudiants = etudiantRepository.findAllById(etudiantIds);
        reservation.setEtudiants(etudiants);  // Assign Etudiants to the Reservation

        return reservationRepository.save(reservation);  // Save the Reservation with the assigned Chambre and Etudiants
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        // Retrieve the associated Bloc
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc not found"));

        // Retrieve the Student by CIN (assuming CIN is a unique identifier for students)
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Etudiant not found"));

        // Get the list of all available rooms in the bloc
        List<Chambre> availableChambres = chambreRepository.findByBloc(bloc);

        for (Chambre chambre : availableChambres) {
            // Check if the room is of the correct type and has available capacity
            if ((chambre.getType() == TypeChambre.SIMPLE && chambre.getReservations().size() < 1) ||
                    (chambre.getType() == TypeChambre.DOUBLE && chambre.getReservations().size() < 2) ||
                    (chambre.getType() == TypeChambre.TRIPLE && chambre.getReservations().size() < 3)) {

                // Construct the numReservation
                String numReservation = chambre.getNumeroChambre() + "-" + bloc.getNomBloc() + "-2025"; // Example: "101-BlocA-2025"

                // Create the new Reservation
                Reservation reservation = new Reservation();
                reservation.setChambre(chambre);               // Assign the room to the reservation
                reservation.setEtudiants(List.of(etudiant));   // Assign the student to the reservation
                reservation.setEstValide(true);               // Set the reservation as valid
                reservation.setAnneeUniversitaire(new Date()); // Set the academic year (you can adjust this logic)

                // Save the reservation
                return reservationRepository.save(reservation);
            }
        }

        // If no available room is found
        throw new RuntimeException("No available room for this reservation");
    }

}
