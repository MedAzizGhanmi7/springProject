package tn.esprit.medazizg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.medazizg.entity.Etudiantt;
import tn.esprit.medazizg.repository.EtudiantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantServiceImpl implements EtudiantService {
EtudiantRepository etudiantRepository;
@Autowired
    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiantt createEtudiantt(Etudiantt etudiant) {return etudiantRepository.save(etudiant);}
    @Override
    public Optional<Etudiantt> getEtudianttById(long id) {return etudiantRepository.findById(id);}
    @Override
    public List<Etudiantt> getAllEtudiantts() {return etudiantRepository.findAll();}
    @Override
    public Etudiantt updateEtudiantt( Etudiantt etudiant) {return etudiantRepository.save(etudiant);}
    @Override
    public void deleteEtudiantt(long id) {etudiantRepository.deleteById(id);}
    @Override
    public List<Etudiantt> findByReservationsIdReservation(String idReservation) {return  etudiantRepository.findByReservationsIdReservation(idReservation);}
}
