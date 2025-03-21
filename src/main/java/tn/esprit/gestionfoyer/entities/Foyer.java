package tn.esprit.gestionfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    private String nomFoyer;

    private long capaciteFoyer;

    @OneToOne
    private Universite universite;

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Bloc> blocs;
}
