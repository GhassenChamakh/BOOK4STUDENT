package tn.esprit.myfirstproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.myfirstproject.entities.Bloc;
import tn.esprit.myfirstproject.entities.Foyer;
import tn.esprit.myfirstproject.entities.Universite;
import tn.esprit.myfirstproject.repositories.IFoyerRepository;
import tn.esprit.myfirstproject.repositories.IUniversiteRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IUniversiteServicesImp implements IUniversiteServices {
    IUniversiteRepository universiteRepo;
    IFoyerRepository foyerRepo;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite addUniversite(Universite b) {
        return universiteRepo.save(b);
    }

    @Override
    public Universite updateUniversite(Universite b) {
        return universiteRepo.save(b);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepo.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) { //one to one
        Foyer foyer = foyerRepo.findById(idFoyer).orElse(null);
        Universite universite = universiteRepo.findByNomUniversite(nomUniversite);
        universite.setFoyer(foyer);
        //universiteRepo.save(universite); not required with java 8
        return universiteRepo.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite) {
        Foyer foyer = foyerRepo.findById(idFoyer).orElse(null);
        Universite universite = universiteRepo.findUniversiteByIdUniversite(idUniversite);
        universite.setFoyer(null);
        //universiteRepo.save(universite); not required with java 8
        return universiteRepo.save(universite);
    }


}
