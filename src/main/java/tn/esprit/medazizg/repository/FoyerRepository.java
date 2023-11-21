package tn.esprit.medazizg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.medazizg.entity.Foyer;

import java.util.List;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer,Long> {
    List<Foyer> findByBlocsNomBloc(String nomBloc);

}
