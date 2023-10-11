package tn.esprit.medazizg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Foyer implements Serializable {
    @Id
    private long idFoyer;
    private  String nomFoyer;
    private long capaciteFoyer;

}
