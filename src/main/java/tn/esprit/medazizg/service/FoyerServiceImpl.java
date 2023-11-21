package tn.esprit.medazizg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.medazizg.entity.Foyer;
import tn.esprit.medazizg.repository.FoyerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoyerServiceImpl implements FoyerService{
    FoyerRepository foyerRepository;

    @Autowired
    public FoyerServiceImpl(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }

    @Override
    public Foyer createFoyer(Foyer foyer) {return foyerRepository.save(foyer);}
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
}
