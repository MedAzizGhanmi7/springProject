package tn.esprit.medazizg.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.medazizg.entity.Bloc;
import tn.esprit.medazizg.entity.Chambre;
import tn.esprit.medazizg.entity.Universite;
import tn.esprit.medazizg.entity.typeChambre;
import tn.esprit.medazizg.repository.BlocRepository;
import tn.esprit.medazizg.repository.ChambreRepository;
import tn.esprit.medazizg.repository.UniversiteRepository;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ChambreServiceImpl implements ChambreService{
    ChambreRepository chambreRepository;
     UniversiteRepository universiteRepository;
    BlocRepository blocRepository;
@Autowired
    public ChambreServiceImpl(BlocRepository blocRepository,ChambreRepository chambreRepository, UniversiteRepository universiteRepository
) {
        this.chambreRepository = chambreRepository;
        this.universiteRepository=universiteRepository;
    this.blocRepository = blocRepository;
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

    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {

            Bloc bloc = blocRepository.findById(idBloc).get();
            List<Chambre> chambres = chambreRepository.findAllById(numChambre);
            chambres.forEach(chambre -> chambre.setBloc(bloc));
            chambreRepository.saveAll(chambres);
            return bloc;

    }
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        Universite universite = universiteRepository.findFirstByUniversiteAndFoyerIsNull(nomUniversite);
        if (universite == null) {
            throw new RuntimeException("Université non trouvée");
        }
        return chambreRepository.findByBlocFoyerUniversiteUniversite(universite);
    }

  //Approche Spring Data JPA (méthodes de mots-clés) :
    public List<Chambre> getChambresParBlocEtType(long idBloc, typeChambre typeC) {
        return chambreRepository.findByBlocIdBlocAndTypeC(idBloc, typeC);
    }

    //Approche JPQL :
    @PersistenceContext
    private EntityManager entityManager;
    public List<Chambre> getChambresParBlocEtTypeJPQL(long idBloc, typeChambre typeC) {
        String jpqlQuery = "SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC";
        TypedQuery<Chambre> query = entityManager.createQuery(jpqlQuery, Chambre.class);
        query.setParameter("idBloc", idBloc);
        query.setParameter("typeC", typeC);
        return query.getResultList();
    }

    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(
            String nomUniversite, typeChambre type) {
        Date currentDate = new Date(System.currentTimeMillis());
        return chambreRepository.findByBlocFoyerUniversiteUniversiteAndTypeCAndReservationsAnneeUniversitaireAndReservationsEstValideIsTrue(
                nomUniversite, type, currentDate);
    }



}
