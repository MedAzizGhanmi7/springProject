package tn.esprit.medazizg.service;

import tn.esprit.medazizg.entity.Chambre;

import java.util.List;
import java.util.Optional;

public interface ChambreService {
    Chambre createChambre(Chambre chambre);
    Optional<Chambre> getChambreById(long id);
    List<Chambre> getAllChambres();
    Chambre updateChambre(Chambre chambre);
    void deleteChambre(long id);

    List<Chambre> findByBlocNomBloc(String nomBloc);

}
