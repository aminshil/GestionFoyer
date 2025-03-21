package tn.esprit.gestionfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Etudiant;
import tn.esprit.gestionfoyer.entities.Reservation;
import tn.esprit.gestionfoyer.repository.IEtudiantRepository;
import tn.esprit.gestionfoyer.repository.IReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    IReservationRepository reservationRepository;
    IEtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant findById(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    public Etudiant addReservationToEtudiant(Etudiant etudiant, List<Long> reservationIds) {
        List<Reservation> reservations = reservationRepository.findAllById(reservationIds);
        etudiant.setReservations(reservations);  // Set the Reservations in Etudiant
        return etudiantRepository.save(etudiant);  // Save the Etudiant with the assigned Reservations
    }

}
