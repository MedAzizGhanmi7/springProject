package tn.esprit.medazizg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.medazizg.entity.Foyer;
import tn.esprit.medazizg.entity.Universite;
import tn.esprit.medazizg.repository.FoyerRepository;
import tn.esprit.medazizg.repository.UniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteServiceImpl implements UniversiteService{
    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;
@Autowired
    public UniversiteServiceImpl( FoyerRepository foyerRepository,
                                  UniversiteRepository universiteRepository)
{this.universiteRepository = universiteRepository;
    this.foyerRepository = foyerRepository;
}
    @Override
    public Universite createUniversite(Universite Universite) {return universiteRepository.save(Universite);}
    @Override
    public Optional<Universite> getUniversiteById(long id) {
        return universiteRepository.findById(id);
    }
    @Override
    public List<Universite> getAllUniversite() {return universiteRepository.findAll();}
    @Override
    public Universite updateUniversite(Universite Universite) {return universiteRepository.save(Universite);}
    @Override
    public void deleteUniversite(long id) {universiteRepository.deleteById(id);}
    @Override
    public List<Universite> findByFoyerNomFoyer(String nomFoyer) {return universiteRepository.findByFoyerNomFoyer(nomFoyer);}

    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {

        Universite universite = universiteRepository.findFirstByUniversiteAndFoyerIsNull(nomUniversite);
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        universite.setFoyer(foyer);
        return universiteRepository.save(universite);
    }
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).get();
        if (universite != null) {
            universite.setFoyer(null);
        }
        return universiteRepository.save(universite);
    }

}
