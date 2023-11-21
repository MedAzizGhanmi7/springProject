package tn.esprit.medazizg.service;

import tn.esprit.medazizg.entity.Etudiantt;

import java.util.List;
import java.util.Optional;

public interface EtudiantService {
    Etudiantt createEtudiantt(Etudiantt etudiant);
    Optional<Etudiantt> getEtudianttById(long id);
    List<Etudiantt> getAllEtudiantts();
    Etudiantt updateEtudiantt(Etudiantt etudiant);
    void deleteEtudiantt(long id);
    List<Etudiantt> findByReservationsIdReservation(String idReservation);
}
