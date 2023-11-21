package tn.esprit.medazizg.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.medazizg.entity.Foyer;
import tn.esprit.medazizg.entity.Universite;
import tn.esprit.medazizg.service.UniversiteService;

import java.util.List;
import java.util.Optional;

@Tag(name = "manage Universites")
@RestController
@RequestMapping("api/Universites")
public class UniversiteController {
    UniversiteService universiteService;
@Autowired
    public UniversiteController(UniversiteService universiteService) {
        this.universiteService = universiteService;
    }
    @Operation(summary = "add a universite")
    @PostMapping("add")
    public Universite addingUniversite(@RequestBody Universite universite){return universiteService.createUniversite(universite);}
    @Operation(summary = "update a universite")
    @PutMapping("update")
    public Universite updateUniversite(Universite universite){
        return universiteService.updateUniversite(universite);
    }
    @Operation(summary = "get a universite")
    @GetMapping ("get")
    public Optional<Universite> getUniversite(@RequestParam("idUniversite")long idUniversite ){return universiteService.getUniversiteById(idUniversite);}
    @Operation(summary = "get all universites")
    @GetMapping ("getAll")
    public List<Universite> getAllUniversites( ){return universiteService.getAllUniversite();}
    @Operation(summary = "delete a universite")
    @DeleteMapping ("delete/{idUniversite}")
    public void deleteUniversiteById(@PathVariable long idUniversite ){universiteService.deleteUniversite(idUniversite);}
    @Operation(summary = "get all universites by nom foyer")
    @GetMapping ("getAllByNomFoyer/{nomFoyer}")
    public List<Universite> getAllUniversitesByNomFoyer( String nomFoyer){return universiteService.findByFoyerNomFoyer(nomFoyer);}
}
