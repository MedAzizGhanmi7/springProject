package tn.esprit.medazizg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.medazizg.entity.*;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByBlocNomBloc(String nomBloc);
    List<Chambre> findByNumeroChambreIn(List<Long> numeroChambres);

    @Query("SELECT c.reservations FROM Chambre c WHERE c.idChambre = :idChambre")
    Set<Reservation> findReservationsByChambreId(@Param("idChambre") long idChambre);

    @Query("SELECT e FROM Chambre c JOIN c.reservations r JOIN r.etudiants e WHERE c.idChambre = :idChambre")
    Set<Etudiantt> findEtudiantsByChambreId(@Param("idChambre") long idChambre);

   Chambre findByReservationsIdReservation(String idReservation);

    List<Chambre> findByBlocFoyerUniversiteUniversite(Universite universite);

    List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, typeChambre typeC);

    List<Chambre> findByBlocFoyerUniversiteUniversiteAndTypeCAndReservationsAnneeUniversitaireAndReservationsEstValideIsTrue(String nomUniversite, typeChambre type, Date currentDate);

    @Query("SELECT c FROM Chambre c WHERE  NOT EXISTS (SELECT 1 FROM Reservation r JOIN Chambre ch ON r MEMBER OF ch.reservations WHERE YEAR(r.anneeUniversitaire) = :year AND ch.idChambre = c.idChambre) AND c.bloc.idBloc = :blocId Order By c.idChambre limit 1")
    Chambre findChambreWithNoReservationsForYearAndBloc(int year, long blocId);




}
