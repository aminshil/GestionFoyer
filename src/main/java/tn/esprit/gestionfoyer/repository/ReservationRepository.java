package tn.esprit.gestionfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
