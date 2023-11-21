package tn.esprit.medazizg.service;


import tn.esprit.medazizg.entity.Foyer;

import java.util.List;
import java.util.Optional;

public interface FoyerService {
    Foyer createFoyer(Foyer foyer);
    Optional<Foyer> getFoyerById(long id);
    List<Foyer> getAllFoyer();
    Foyer updateFoyer(Foyer foyer);
    void deleteFoyer(long id);
    List<Foyer> findByBlocsNomBloc(String nomBloc);

}
