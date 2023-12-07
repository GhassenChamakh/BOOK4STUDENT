package tn.esprit.myfirstproject.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.myfirstproject.entities.Bloc;
import tn.esprit.myfirstproject.entities.Etudiant;
import tn.esprit.myfirstproject.entities.Foyer;
import tn.esprit.myfirstproject.entities.Universite;
import tn.esprit.myfirstproject.repositories.IBlocRepository;
import tn.esprit.myfirstproject.repositories.IEtudiantRepository;
import tn.esprit.myfirstproject.repositories.IFoyerRepository;
import tn.esprit.myfirstproject.repositories.IUniversiteRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class IFoyerServicesImp implements IFoyerServices {

    IFoyerRepository foyerRepo;
    IBlocRepository blocRepo;
    IUniversiteRepository universiteRepo;


    @Override

    public List<Foyer> retrieveAllFoyers() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer b) {
        return foyerRepo.save(b);
    }

    @Override
    public Foyer updateFoyer(Foyer b) {
        return foyerRepo.save(b);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepo.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepo.deleteById(idFoyer);
    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Bloc bloc = blocRepo.findBlocByNomBloc(nomBloc);
        Foyer foyer = foyerRepo.findFoyerByNomFoyer(nomFoyer);
        Set<Bloc> blocs = new HashSet<>();
        blocs.add(bloc);
        foyer.setBlocs(blocs);
        foyerRepo.save(foyer);
        return bloc;
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        this.addFoyer(foyer);
        Universite universite = universiteRepo.findUniversiteByIdUniversite(idUniversite);
        foyer.setUniversite(universite);
        foyerRepo.save(foyer);
        universiteRepo.save(universite);
        return foyer;
    }

}
