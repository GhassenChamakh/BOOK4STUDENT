package tn.esprit.myfirstproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.myfirstproject.entities.Bloc;
import tn.esprit.myfirstproject.entities.Chambre;
import tn.esprit.myfirstproject.entities.Reservation;
import tn.esprit.myfirstproject.entities.TypeChambre;
import tn.esprit.myfirstproject.repositories.IChambreRepository;
import tn.esprit.myfirstproject.repositories.IFoyerRepository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IChambreServicesImp implements IChambreServices {
    IChambreRepository chambreRepo;
    IFoyerRepository foyerRepo;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        System.out.println("get");
        return chambreRepo.findById(idChambre).orElse(null);
    }

    @Override
    public void removeChambre(long idChambre) {
        chambreRepo.deleteById(idChambre);
    }

    @Override
    public List<Chambre> getChambreByNomBloc(String nom) {
        return chambreRepo.findChambresByBlocs_NomBloc(nom);
    }

    @Override
    public List<Chambre> getChambreByType(TypeChambre type) {
        return chambreRepo.findByTypeC(type);
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        return 0;
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {

        return chambreRepo.findChambresByBlocs_NomBloc(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepo.findChambresByTypeCAndBlocs_IdBloc(typeC, idBloc);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return null;
    }
    //recupere les chambres dont ils ont ete reserve durant une annee universitaire donner au clavier

    List<Chambre> getChambreByReservationAnneeUniversitaire(LocalDate  debut, LocalDate fin) {
        List<Chambre> chambres = null;

        for (Chambre c : chambreRepo.findAll())
            for (Reservation r : c.getReservations())
                if (r.getDebutAnneeUniv().isAfter(debut) && r.getDebutAnneeUniv().isBefore(fin))
                    chambres.add(c);
        return chambres;

    }

    // @Scheduled(fixedRate = 5000)
    // @Scheduled(fixedDelay = 5000)
    // @Scheduled(cron = "5 * * * * *") // 5eme seconde
    // @Scheduled(cron = "* 10 * * * *") // chaque seconde de la 10eme minute
    // @Scheduled(cron = "* 10 5 * * *") // chaque seconde de la 10eme minute ,5eme heure de chaque jour de chaque mois de chaque jour de la semaine
    // @Scheduled(cron = "3/5 10 5 * * *")// de 3s vers 5 secondes
    @Scheduled(cron = "*/5 10 5 * * *")// toute les 5 secondes

    void testSchedular() throws InterruptedException {
        log.info("test scheduling fixedRate");
        // TimeUnit.SECONDS.sleep(5);
        //   Thread.sleep(5000); // pr delay
    }

}


