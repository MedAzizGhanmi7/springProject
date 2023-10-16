package tn.esprit.medazizg.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = "idBloc")
@EqualsAndHashCode(exclude = "idBloc")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long idBloc ;

    private long capaciteBloc ;

    @NonNull
    private String nomBloc;

    @ManyToOne
    private Foyer foyer ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "bloc")
    private Set<Chambre> chambres ;

}
