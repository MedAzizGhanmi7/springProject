package tn.esprit.medazizg.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString(exclude = "idEtudiant")
@EqualsAndHashCode(exclude = "idEtudiant")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor



public class Etudiantt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long idEtudiant ;
    @NonNull
    private String nomEt ;
    @NonNull
    private String prenomEt ;
    private long cin ;
    @NonNull
    private String ecole ;
    @NonNull
    private Date dateNaissance ;

    @ManyToMany (cascade = CascadeType.ALL)
    private Set<Reservation> reservations ;

}
