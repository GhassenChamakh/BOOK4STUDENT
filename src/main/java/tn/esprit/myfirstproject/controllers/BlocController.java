package tn.esprit.myfirstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.myfirstproject.entities.Bloc;
import tn.esprit.myfirstproject.services.IBlocServices;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/bloc")
@RequiredArgsConstructor
public class BlocController {

    IBlocServices iBlocService;
    @GetMapping("/afficherblocs")
    List<Bloc> retrieveAllBlocs() {
        return iBlocService.retrieveAllBlocs();
    }

    @PostMapping("/ajouterbloc")
    Bloc addBloc(@RequestBody Bloc c) {
        return iBlocService.addBloc(c);
    }

    @PutMapping("/modifierbloc")
    Bloc updateBloc(@RequestBody Bloc c) {
        return iBlocService.updateBloc(c);
    }

    @GetMapping("/afficherbloc/{idbloc}")
    Bloc retrieveBloc(@PathVariable("idbloc") long idBloc) {
        return iBlocService.retrieveBloc(idBloc);
    }

    @DeleteMapping("/supprimerbloc/{idbloc}")
    String deleteBloc(@PathVariable("idbloc") long idBloc) {
        iBlocService.removeBloc(idBloc);
        return ("Bloc est supprimer");
    }

    @PutMapping("/affecterchambreabloc/{numChambre}/{nomBloc}")
    Bloc affecterChambresABloc(@PathVariable("numChambre") List<Long> numChambre, @PathVariable("nomBloc") String nomBloc) {
        return iBlocService.affecterChambresABloc(numChambre, nomBloc);
    }
}
