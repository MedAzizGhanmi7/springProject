package tn.esprit.medazizg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Universite implements Serializable {
    @Id
    private long idUniversite;
    private String universite;
    private String adresse;

}
