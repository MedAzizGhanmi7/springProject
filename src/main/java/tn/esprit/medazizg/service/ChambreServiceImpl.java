package tn.esprit.medazizg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.medazizg.entity.Chambre;
import tn.esprit.medazizg.repository.ChambreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreServiceImpl implements ChambreService{
    ChambreRepository chambreRepository;
@Autowired
    public ChambreServiceImpl(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @Override
    public Chambre createChambre(Chambre chambre) {return chambreRepository.save(chambre);}
    @Override
    public Optional<Chambre> getChambreById(long id) {return chambreRepository.findById(id);}
    @Override
    public List<Chambre> getAllChambres() {
    return chambreRepository.findAll();
    }
    @Override
    public Chambre updateChambre(Chambre chambre) {
    return chambreRepository.save(chambre);
    }
    @Override
    public void deleteChambre(long id) {chambreRepository.deleteById(id);}
    @Override
    public List<Chambre> findByBlocNomBloc(String nomBloc) {
        return chambreRepository.findByBlocNomBloc(nomBloc);
    }
}
