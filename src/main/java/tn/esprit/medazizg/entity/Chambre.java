package tn.esprit.medazizg.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = "idChambre")
@EqualsAndHashCode(exclude = "idChambre")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long idChambre;
    private long numeroChambre;
    @NonNull
    private  typeChambre typeC;
    @ManyToOne
    private Bloc bloc;
    @OneToMany (cascade = CascadeType.ALL)
    private Set <Reservation> reservations ;

}
