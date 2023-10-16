package tn.esprit.medazizg.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Setter
@Getter
@ToString(exclude = "idUniversite")
@EqualsAndHashCode(exclude = "idUniversite")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor


public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long idUniversite;
    @NonNull
    private String universite;
    @NonNull
    private String adresse;
    @OneToOne(cascade = CascadeType.ALL)
    private Foyer foyer ;

}
