package tn.esprit.medazizg.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString(exclude = "idFoyer")
@EqualsAndHashCode(exclude = "idFoyer")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long idFoyer;
    @NonNull
    private  String nomFoyer;
    private long capaciteFoyer;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "foyer")
    private Set<Bloc> blocs ;
    @OneToOne(cascade = CascadeType.ALL , mappedBy = "foyer")
    private Universite universite ;


}
