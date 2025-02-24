package tn.esprit.gestionfoyer.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    private String nomBloc;
    private long capaciteBloc;

    @ManyToOne
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    private List<Chambre> chambres;
}

