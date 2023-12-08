package tn.esprit.medazizg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.medazizg.entity.Reservation;

import java.sql.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,String> {
    List<Reservation> findByEtudiantsIdEtudiant(long idEtudiant);

    @Query("SELECT r FROM Reservation r " +
            "JOIN Chambre c ON r MEMBER OF c.reservations " +
            "WHERE (r.estValide = true " +
            "AND YEAR(r.anneeUniversitaire) = YEAR(current_date) " +
            "AND c.bloc.idBloc = :blocId) ORDER BY r.idReservation limit 1")
    Reservation findValidReservationsForYearAndBloc( long blocId);


}




