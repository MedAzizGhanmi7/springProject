package tn.esprit.medazizg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.medazizg.entity.Reservation;
import tn.esprit.medazizg.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{
    ReservationRepository reservationRepository;
@Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {this.reservationRepository = reservationRepository;}
    @Override
    public Reservation createReservation(Reservation reservation) {return reservationRepository.save(reservation);}
    @Override
    public Optional<Reservation> getReservationById(String id) {return reservationRepository.findById(id);}
    @Override
    public List<Reservation> getAllReservation() {return reservationRepository.findAll();}
    @Override
    public Reservation updateReservation( Reservation reservation) {return reservationRepository.save(reservation);}
    @Override
    public void deleteReservation(String id) {reservationRepository.deleteById(id);}
    @Override
    public List<Reservation> findByEtudiantsIdEtudiant(long idEtudiant) {return reservationRepository.findByEtudiantsIdEtudiant(idEtudiant);}
}
