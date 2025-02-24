package tn.esprit.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    @Column(nullable = false)
    private String nomFoyer; // Updated field name

    @Column(nullable = false)
    private long capaciteFoyer; // Updated field name

    @OneToOne
    private Universite universite;


    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL)
    private List<Bloc> blocs;
}
