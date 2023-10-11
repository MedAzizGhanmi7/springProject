package tn.esprit.medazizg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.sql.Date;
@Entity
public class Reservation implements Serializable {
@Id
    private String idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;
}
