package tn.esprit.myfirstproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.myfirstproject.entities.Chambre;
import tn.esprit.myfirstproject.entities.Etudiant;
import tn.esprit.myfirstproject.entities.Reservation;
import tn.esprit.myfirstproject.entities.TypeChambre;
import tn.esprit.myfirstproject.repositories.IChambreRepository;
import tn.esprit.myfirstproject.repositories.IEtudiantRepository;
import tn.esprit.myfirstproject.repositories.IReservationRepository;

import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class IReservationServicesImp{

}
