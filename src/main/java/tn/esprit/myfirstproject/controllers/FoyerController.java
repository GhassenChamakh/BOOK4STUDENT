package tn.esprit.myfirstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.myfirstproject.entities.Bloc;
import tn.esprit.myfirstproject.entities.Foyer;
import tn.esprit.myfirstproject.services.IFoyerServices;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/foyer")
@RequiredArgsConstructor
public class FoyerController {

  IFoyerServices iFoyerService;

    @GetMapping("/afficherfoyers")
    List<Foyer> retrieveAllFoyers() {
        return iFoyerService.retrieveAllFoyers();
    }

    @PostMapping("/ajouterfoyer")
    Foyer addFoyer(@RequestBody Foyer c) {
        return iFoyerService.addFoyer(c);
    }

    @PutMapping("/modifierfoyer")
    Foyer updateFoyer(@RequestBody Foyer c) {
        return iFoyerService.updateFoyer(c);
    }

    @GetMapping("/afficherfoyer/{idfoyer}")
    Foyer retrieveFoyer(@PathVariable("idfoyer") long idFoyer) {
        return iFoyerService.retrieveFoyer(idFoyer);
    }

    @DeleteMapping("/supprimerfoyer/{idfoyer}")
    String removeFoyer(@PathVariable("idfoyer") long idFoyer) {
        iFoyerService.removeFoyer(idFoyer);
        return ("Foyer est supprimer");
    }

    @PutMapping("/affecterBlocAFoyer/{nomBloc}/{nomFoyer}")
    Bloc affecterBlocAFoyer(@PathVariable("nomBloc") String nomBloc, @PathVariable("nomFoyer") String nomFoyer) {
        return iFoyerService.affecterBlocAFoyer(nomBloc, nomFoyer);
    }

    @PostMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer f, @PathVariable("idUniversite") Long idUniversite) {
        return iFoyerService.ajouterFoyerEtAffecterAUniversite(f, idUniversite);
    }
}