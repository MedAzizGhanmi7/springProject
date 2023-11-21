package tn.esprit.medazizg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.medazizg.entity.Universite;
import tn.esprit.medazizg.repository.UniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteServiceImpl implements UniversiteService{
    UniversiteRepository universiteRepository;
@Autowired
    public UniversiteServiceImpl(UniversiteRepository universiteRepository) {this.universiteRepository = universiteRepository;}
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
}
