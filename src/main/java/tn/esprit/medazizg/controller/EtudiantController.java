package tn.esprit.medazizg.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.medazizg.entity.Chambre;
import tn.esprit.medazizg.entity.Etudiantt;
import tn.esprit.medazizg.service.EtudiantService;

import java.util.List;
import java.util.Optional;

@Tag(name = "manage Etudiants")
@RestController
@RequestMapping("api/etudiants")
public class EtudiantController {
    EtudiantService etudiantService;
    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }
    @Operation(summary = "add a student")
    @PostMapping("add")
    public Etudiantt addingEtudiant(@RequestBody Etudiantt etudiant){return etudiantService.createEtudiantt(etudiant);}
    @Operation(summary = "edit a student")
    @PutMapping("update")
    public Etudiantt updateEtudiant(Etudiantt etudiant){
        return etudiantService.updateEtudiantt(etudiant);
    }
    @Operation(summary = "get a student")
    @GetMapping ("get")
    public Optional<Etudiantt> getChambre(@RequestParam("idEtudiant")long idEtudiant ){return etudiantService.getEtudianttById(idEtudiant);}
    @Operation(summary = "get all students")
    @GetMapping ("getAll")
    public List<Etudiantt> getAllEtudiantts( ){return etudiantService.getAllEtudiantts();}
    @Operation(summary = "delete a student")
    @DeleteMapping ("delete/{idEtudiant}")
    public void deleteEtudiantt(@PathVariable long idEtudiant ){etudiantService.deleteEtudiantt(idEtudiant);}
    @Operation(summary = "get a student by Reservation Id")
    @GetMapping ("getAllByIdReservation/{idReservation}")
    public List<Etudiantt> getAllEtudianttsByIdReservation( String idReservation){return etudiantService.findByReservationsIdReservation(idReservation);}
}
