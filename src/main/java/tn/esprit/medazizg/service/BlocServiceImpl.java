package tn.esprit.medazizg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.medazizg.entity.Bloc;
import tn.esprit.medazizg.repository.BlocRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlocServiceImpl implements BlocService{
    BlocRepository blocRepository;
    @Autowired
    public BlocServiceImpl(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }
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
}
