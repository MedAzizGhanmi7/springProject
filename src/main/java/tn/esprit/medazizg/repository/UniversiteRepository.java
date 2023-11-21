package tn.esprit.medazizg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.medazizg.entity.Universite;

import java.util.List;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    List<Universite> findByFoyerNomFoyer(String nomFoyer);

}
