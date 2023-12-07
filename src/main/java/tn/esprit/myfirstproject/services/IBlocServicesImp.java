package tn.esprit.myfirstproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.myfirstproject.entities.Bloc;
import tn.esprit.myfirstproject.entities.Chambre;
import tn.esprit.myfirstproject.entities.Etudiant;
import tn.esprit.myfirstproject.entities.Foyer;
import tn.esprit.myfirstproject.repositories.IBlocRepository;
import tn.esprit.myfirstproject.repositories.IChambreRepository;
import tn.esprit.myfirstproject.repositories.IFoyerRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IBlocServicesImp implements IBlocServices {

    IBlocRepository blocRepo;
    IChambreRepository chambreRepo;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepo.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepo.save(b);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepo.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepo.deleteById(idBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc bloc = blocRepo.findBlocByNomBloc(nomBloc);
        Chambre chambre;
        for (long num : numChambre) {
            //     (chambreRepo.findChambresByNumeroChambre(num)).setBlocs(bloc);
            chambre = chambreRepo.findChambresByNumeroChambre(num);
            chambre.setBlocs(bloc); //plus important set moins important(cardinalite)
            chambreRepo.save(chambre);
        }
        // return  blocRepo.save(bloc);
        return blocRepo.findBlocByNomBlocs(nomBloc);
    }
}

