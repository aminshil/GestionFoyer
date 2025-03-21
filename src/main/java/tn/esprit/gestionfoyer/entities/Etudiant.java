package tn.esprit.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    private long cin; // Changed from String to long

    private String nomET; // Changed to match description

    private String prenomEt; // Changed to match description

    private String ecole; // Added missing field

    private Date dateNaissance; // Added missing field

    @ManyToMany
    private List<Reservation> reservations;

}
