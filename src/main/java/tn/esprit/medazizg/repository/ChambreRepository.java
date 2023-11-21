package tn.esprit.medazizg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.medazizg.entity.Chambre;
import tn.esprit.medazizg.entity.Etudiantt;
import tn.esprit.medazizg.entity.Reservation;

import java.util.List;
import java.util.Set;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByBlocNomBloc(String nomBloc);

    @Query("SELECT c.reservations FROM Chambre c WHERE c.idChambre = :idChambre")
    Set<Reservation> findReservationsByChambreId(@Param("idChambre") long idChambre);

    @Query("SELECT e FROM Chambre c JOIN c.reservations r JOIN r.etudiants e WHERE c.idChambre = :idChambre")
    Set<Etudiantt> findEtudiantsByChambreId(@Param("idChambre") long idChambre);
}
