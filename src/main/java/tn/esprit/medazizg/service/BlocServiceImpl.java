package tn.esprit.medazizg.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.medazizg.entity.Bloc;
import tn.esprit.medazizg.entity.Foyer;
import tn.esprit.medazizg.repository.BlocRepository;
import tn.esprit.medazizg.repository.FoyerRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class BlocServiceImpl implements BlocService{
    BlocRepository blocRepository;
    FoyerRepository foyerRepository;

    @Override
    public Bloc createBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }
    @Override
    public Optional<Bloc> getBlocById(long id) {return blocRepository.findById(id);}
    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }
    @Override
    public Bloc updateBloc( Bloc bloc) {return blocRepository.save(bloc);}
    @Override
    public void deleteBloc(long id) {blocRepository.deleteById(id);}
    @Override
    public  List<Bloc>  getBlocByIdUniversite(long id) {
        return blocRepository.findByFoyerUniversiteIdUniversite(id);
    }

    @Scheduled(fixedRate = 30000)
    public void printBlockList() {

        System.out.println("Liste des blocs :");
        System.out.println(blocRepository.findAll().toString());
    }
   @Override
   @Transactional
   public void affecterBlocAfoyer(Foyer foyer, Set<Bloc> blocs){
       blocs.forEach(bloc -> bloc.setFoyer(foyer));
       blocRepository.saveAll(blocs);


    }
}
