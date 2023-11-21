package tn.esprit.medazizg.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.medazizg.entity.Bloc;
import tn.esprit.medazizg.entity.Chambre;
import tn.esprit.medazizg.service.ChambreService;

import java.util.List;
import java.util.Optional;
@Tag(name = "manage Chambres")
@RestController
@RequestMapping("api/chambres")
public class ChambreController {
 ChambreService chambreService;
@Autowired
    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }
    @Operation(summary = "add a room")
    @PostMapping("add")
    public Chambre addingChambre(@RequestBody Chambre chambre){
    return chambreService.createChambre(chambre);
    }
    @Operation(summary = "edit a room")
    @PutMapping("update")
    public Chambre updateChambre(Chambre chambre){
        return chambreService.updateChambre(chambre);
    }
    @Operation(summary = "get a room")
    @GetMapping ("get")
    public Optional<Chambre> getChambre(@RequestParam("idChambre")long idChambre ){return chambreService.getChambreById(idChambre);}
    @Operation(summary = "get all rooms")
    @GetMapping ("getAll")
    public List<Chambre> getAllChambres( ){return chambreService.getAllChambres();}
    @Operation(summary = "delete a room")
    @DeleteMapping ("delete/{idChambre}")
    public void deleteChambreById(@PathVariable long idChambre ){chambreService.deleteChambre(idChambre);}
    @Operation(summary = "get a room by bloc name")
    @GetMapping ("getAllChambresNomBloc/{nomBloc}")
    public List<Chambre> findByBlocNomBloc( @PathVariable String nomBloc){return chambreService.findByBlocNomBloc(nomBloc);}
}
