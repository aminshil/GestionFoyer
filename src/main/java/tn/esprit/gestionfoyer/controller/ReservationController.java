package tn.esprit.gestionfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Reservation;
import tn.esprit.gestionfoyer.services.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {

   IReservationService reservationService;

    // Save a new Reservation
    @PostMapping("/savereservation")
    public Reservation saveReservation(@RequestBody Reservation reservation) {
        System.out.println("Received Reservation: " + reservation);
        return reservationService.addReservation(reservation);
    }

    // Get all Reservations
    @GetMapping("/allreservations")
    public List<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    // Get a specific Reservation by ID
    @GetMapping("/{idReservation}")
    public Reservation getReservationById(@PathVariable long idReservation) {
        return reservationService.findById(idReservation);
    }

    // Update an existing Reservation
    @PutMapping("/updatereservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    // Delete a Reservation by ID
    @DeleteMapping("/removereservation/{idReservation}")
    public void removeReservation(@PathVariable long idReservation) {
        reservationService.removeReservation(idReservation);
    }

    // Endpoint to add a reservation and assign it to a room and a student
    @PostMapping("/ajouterReservation/{idBloc}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable long idBloc, @PathVariable long cinEtudiant) {
        return reservationService.ajouterReservation(idBloc, cinEtudiant);
    }

}
