package tn.esprit.medazizg.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity

public class Etudiantt implements Serializable {

    @Id
    private long idEtudiant ;
    private String nomEt ;
    private String prenomEt ;
    private long cin ;
    private String ecole ;
    private Date dateNaissance ;

}
