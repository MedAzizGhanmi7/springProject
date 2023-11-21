package tn.esprit.medazizg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.medazizg.entity.Etudiantt;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiantt,Long> {

    List<Etudiantt> findByReservationsIdReservation(String idReservation);

}
