package tn.esprit.gestionfoyer.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    private Long numeroChambre;


    @Enumerated(EnumType.STRING)
    private TypeChambre type;

    @ManyToOne
    @JsonIgnore
    private Bloc bloc;

    @OneToMany
    private List<Reservation> reservations;
}
