package tn.esprit.gestionfoyer.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    private boolean estValide;

    private Date anneeUniversitaire;

    @ManyToOne
    private Chambre chambre;

    @ManyToMany(mappedBy = "reservations")
    private List<Etudiant> etudiants;
}

