package tn.esprit.medazizg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.medazizg.entity.Bloc;
import tn.esprit.medazizg.entity.Universite;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {

    List<Bloc> findByFoyerUniversiteIdUniversite(long idUniversite) ;

    @Query("SELECT b.foyer.universite FROM Bloc b WHERE b.idBloc = :idBloc")
    Universite findUniversiteByBlocId(@Param("idBloc") long idBloc);

}
