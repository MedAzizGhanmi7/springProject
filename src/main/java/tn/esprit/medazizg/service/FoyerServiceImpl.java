package tn.esprit.medazizg.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.medazizg.entity.Bloc;
import tn.esprit.medazizg.entity.Foyer;
import tn.esprit.medazizg.entity.Universite;
import tn.esprit.medazizg.repository.BlocRepository;
import tn.esprit.medazizg.repository.FoyerRepository;
import tn.esprit.medazizg.repository.UniversiteRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@AllArgsConstructor
@Service
public class FoyerServiceImpl implements FoyerService{
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;
    UniversiteRepository universiteRepository;
    BlocService blocService;



    @Override
    public Foyer createFoyer(Foyer foyer) {

        Foyer foyer1 = foyerRepository.save(foyer);

        foyer1.getBlocs().forEach(bloc -> {
            System.err.println(bloc.getIdBloc());
        });
        //blocService.affecterBlocAfoyer(foyer2,blocs);
        return  foyer1;
    }
    @Override
    public Optional<Foyer> getFoyerById(long id) {return foyerRepository.findById(id);}
    @Override
    public List<Foyer> getAllFoyer() {return foyerRepository.findAll();}
    @Override
    public Foyer updateFoyer( Foyer foyer) {
        return foyerRepository.save(foyer);
    }
    @Override
    public void deleteFoyer(long id) {
    foyerRepository.deleteById(id);
    }
    @Override
    public List<Foyer> findByBlocsNomBloc(String nomBloc) {return foyerRepository.findByBlocsNomBloc(nomBloc);}

    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        try {
            Optional<Universite> optionalUniversite = universiteRepository.findById(idUniversite);
            Universite universite = optionalUniversite.orElseThrow(() -> new RuntimeException("Université non trouvée"));
            foyer.setUniversite(universite);
            Foyer savedFoyer = foyerRepository.save(foyer);
            Set<Bloc> blocs = foyer.getBlocs();
            blocs.forEach(bloc -> {
                bloc.setFoyer(savedFoyer);
                blocRepository.save(bloc);
            });
            savedFoyer.setBlocs(new HashSet<>(blocs));
            return savedFoyer;
        } catch (Exception e) {
            // Handle exceptions accordingly
            throw new RuntimeException("Erreur lors de l'ajout du foyer et de son association à l'université : " + e.getMessage());
        }
    }

}
