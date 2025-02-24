package tn.esprit.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    @Column(nullable = false, unique = true)
    private String nomUniversite;

    @Column(nullable = false) // Added missing field
    private String adresse;

    @OneToOne(mappedBy = "universite") // Reference the field in Foyer
    private Foyer foyer;
}
