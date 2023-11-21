package tn.esprit.medazizg.service;

import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.medazizg.entity.Bloc;

import java.util.List;
import java.util.Optional;

public interface BlocService {
    Bloc createBloc(Bloc bloc);
    Optional<Bloc> getBlocById(long id);
    List<Bloc> getAllBlocs();
    Bloc updateBloc(Bloc bloc);

    void deleteBloc(long id);
    List<Bloc>  getBlocByIdUniversite(long id);



}
