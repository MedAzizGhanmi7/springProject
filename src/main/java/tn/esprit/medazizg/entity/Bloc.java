package tn.esprit.medazizg.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = {"idBloc","foyer","chambres"})
@EqualsAndHashCode(exclude = {"idBloc","foyer","chambres"})
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Foyer foyer ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "bloc")
    private Set<Chambre> chambres ;

}
