package tn.esprit.medazizg.service;



import tn.esprit.medazizg.entity.Universite;

import java.util.List;
import java.util.Optional;

public interface UniversiteService {
    Universite createUniversite(Universite Universite);
    Optional<Universite> getUniversiteById(long id);
    List<Universite> getAllUniversite();
    Universite updateUniversite(Universite Universite);
    void deleteUniversite(long id);
    List<Universite> findByFoyerNomFoyer(String nomFoyer);

}
