package tn.esprit.medazizg.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString(exclude = "idReservation")
@EqualsAndHashCode(exclude = "idReservation")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Reservation implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@SequenceGenerator(name = "reservation_sequence", sequenceName = "reservation_seq", allocationSize = 1)
@Setter(AccessLevel.NONE)

    @NonNull
    private String idReservation;
    @NonNull
    private Date anneeUniversitaire;

    private boolean estValide;
    @ManyToMany  (cascade = CascadeType.ALL,mappedBy = "reservations")
    private Set<Etudiantt> etudiants ;
}
