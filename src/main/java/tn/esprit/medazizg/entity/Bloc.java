package tn.esprit.medazizg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity

public class Bloc implements Serializable {
    @Id
    private long idBloc ;
    private long capacite ;
    private String nomBloc;

}
