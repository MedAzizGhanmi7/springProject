package tn.esprit.medazizg.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.medazizg.entity.Bloc;
import tn.esprit.medazizg.service.BlocService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/blocs")
@Tag(name = "manage Blocs")


public class BlocController {
    BlocService blocService;

    @Autowired
    public BlocController(BlocService blocService) {
        this.blocService = blocService;
    }
    @Operation(summary = "Add a bloc")
    @PostMapping("add")
    public Bloc addingBloc(@RequestBody Bloc bloc){
        return blocService.createBloc(bloc);
    }
    @Operation(summary = "Update a bloc")
    @PutMapping ("update")
    public Bloc updateBloc(Bloc bloc){
       return blocService.updateBloc(bloc);
    }
    @Operation(summary = "Get a bloc")
    @GetMapping ("get")
    public Optional<Bloc> getBloc(@RequestParam("idBloc")long idBloc ){
        return blocService.getBlocById(idBloc);
    }
    @Operation(summary = "get all blocs")
    @GetMapping ("getAll")
    public List<Bloc> getAllBlocs( ){
        return blocService.getAllBlocs();
    }
    @Operation(summary = "delete a bloc")
    @DeleteMapping ("delete/{idBloc}")
    public void deleteBlocById(@PathVariable long idBloc ){
        blocService.deleteBloc(idBloc);
    }

    @Operation(summary = "get a bloc by universite Id")
    @GetMapping ("getByIdUni")
    public List<Bloc> getBlocByIdUniversite(long idUni ){
        return blocService.getBlocByIdUniversite(idUni);
    }





}
