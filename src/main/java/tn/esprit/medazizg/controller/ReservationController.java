package tn.esprit.medazizg.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.medazizg.entity.Reservation;
import tn.esprit.medazizg.service.ReservationService;

import java.util.List;
import java.util.Optional;
@Tag(name = "manage Reservations")
@RestController
@RequestMapping("api/reservations")
public class ReservationController {
    ReservationService reservationService;
    @Autowired
    public ReservationController(ReservationService reservationService) {this.reservationService = reservationService;}
    @Operation(summary = "add a Reservation")
    @PostMapping("add")
    public Reservation addingReservation(@RequestBody Reservation reservation){return reservationService.createReservation(reservation);}
    @Operation(summary = "update a Reservation")
    @PutMapping("update")
    public Reservation updateReservation(Reservation reservation){return reservationService.updateReservation(reservation);}
    @Operation(summary = "get a Reservation")
    @GetMapping ("get")
    public Optional<Reservation> getReservation(@RequestParam("idReservation")String idReservation ){return reservationService.getReservationById(idReservation);}
    @Operation(summary = "get all Reservations")
    @GetMapping ("getAll")
    public List<Reservation> getAllReservations( ){return reservationService.getAllReservation();}
    @Operation(summary = "delete a Reservation")
    @DeleteMapping ("delete/{idReservation}")
    public void deleteReservationById(@PathVariable String idReservation ){reservationService.deleteReservation(idReservation);}
    @Operation(summary = "get all Reservations by Etudiant Id")
    @GetMapping ("getAllByIdEtudiant/{idEtudiant}")
    public List<Reservation> getAllReservationsByIdEtudiant(long idEtudiant ){return reservationService.findByEtudiantsIdEtudiant(idEtudiant);}
}
