package tn.esprit.medazizg.service;


import tn.esprit.medazizg.entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);
    Optional<Reservation> getReservationById(String id);
    List<Reservation> getAllReservation();
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(String id);
    List<Reservation> findByEtudiantsIdEtudiant(long idEtudiant);
}
