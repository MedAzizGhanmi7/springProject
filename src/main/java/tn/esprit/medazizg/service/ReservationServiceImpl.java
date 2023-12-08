package tn.esprit.medazizg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.medazizg.entity.*;
import tn.esprit.medazizg.repository.BlocRepository;
import tn.esprit.medazizg.repository.ChambreRepository;
import tn.esprit.medazizg.repository.EtudiantRepository;
import tn.esprit.medazizg.repository.ReservationRepository;

import java.time.ZoneId;
import java.util.*;

@Service
public class ReservationServiceImpl implements ReservationService{
    ReservationRepository reservationRepository;
    ChambreRepository chambreRepository;
    EtudiantService etudiantService;
    EtudiantRepository etudiantRepository;

    BlocRepository blocRepository;
    @Autowired
    public ReservationServiceImpl(ChambreRepository chambreRepository,
                                  ReservationRepository reservationRepository,
                                  EtudiantService etudiantService,
                                  EtudiantRepository etudiantRepository,
                                  BlocRepository blocRepository)
{
    this.reservationRepository = reservationRepository;
    this.chambreRepository=chambreRepository;
    this.etudiantService=etudiantService;
    this.etudiantRepository=etudiantRepository;
    this.blocRepository=blocRepository;

}
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

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {

        Reservation reservation= reservationRepository.findValidReservationsForYearAndBloc(idBloc);
        if(reservation!=null){

            reservation.getEtudiants().add(etudiantRepository.findByCin(cinEtudiant));
            Chambre chambre = chambreRepository.findByReservationsIdReservation(reservation.getIdReservation());
            if(chambre.getTypeC().equals(typeChambre.DOUBLE)||(chambre.getTypeC().equals(typeChambre.TRIPLE)&&reservation.getEtudiants().size() == 3)){
                reservation.setEstValide(false);
            }
            return  reservationRepository.save(reservation);
        } else {
            //To be continued
           // Chambre chambre =
        }

        return reservation;
    }
    }







