package tn.esprit.medazizg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Chambre implements Serializable {
    @Id
    private long idChambre;
    private long numeroChambre;
    private  typeChambre typeC;

}
