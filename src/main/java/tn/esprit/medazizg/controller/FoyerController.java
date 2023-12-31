package tn.esprit.medazizg.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.medazizg.entity.Foyer;
import tn.esprit.medazizg.service.FoyerService;
import tn.esprit.medazizg.service.UniversiteService;

import java.util.List;
import java.util.Optional;
@Tag(name = "manage Foyers")
@RestController
@RequestMapping("api/foyers")
@AllArgsConstructor
public class FoyerController {
    FoyerService foyerService;
    UniversiteService universiteService;

   @Operation(summary = "add a foyer")
   @PostMapping("add")
    public Foyer addingChambre(@RequestBody Foyer foyer){
        return foyerService.createFoyer(foyer);
    }
    @Operation(summary = "edit a foyer")
    @PutMapping("update")
    public Foyer updateFoyer(Foyer foyer){
        return foyerService.updateFoyer(foyer);
    }
    @Operation(summary = "get a foyer")
    @GetMapping ("get")
    public Optional<Foyer> getFoyer(@RequestParam("idFoyer")long idFoyer ){return foyerService.getFoyerById(idFoyer);}
    @Operation(summary = "get all foyers")
    @GetMapping ("getAll")
    public List<Foyer> getAllFoyers( ){return foyerService.getAllFoyer();}
    @Operation(summary = "delete a foyer")
    @DeleteMapping ("delete/{idFoyer}")
    public void deleteFoyerById(@PathVariable long idFoyer ){foyerService.deleteFoyer(idFoyer);}
    @Operation(summary = "get all foyers by bloc name")
    @GetMapping ("getAllByNomBloc/{NomBloc}")
    public List<Foyer> getAllByNomBloc(String NomBloc ){return foyerService.findByBlocsNomBloc(NomBloc);}

    @Operation(summary = "ajouterFoyerEtAffecterAUniversite")
    @PostMapping ("ajouterFoyerEtAffecterAUniversite")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer , @RequestParam Long idUniversite )
    {   /*Foyer foyer1 = foyerService.createFoyer(foyer);
        universiteService.affecterFoyerAUniversite
                (foyer1.getIdFoyer(),universiteService.getUniversiteById(idUniversite)
                        .get().getUniversite());
        return foyer1;*/

        return universiteService.affecterFoyerAUniversite(foyerService.createFoyer(foyer).
                getIdFoyer(),universiteService.getUniversiteById(idUniversite).get().getUniversite()).getFoyer();

    }

}
