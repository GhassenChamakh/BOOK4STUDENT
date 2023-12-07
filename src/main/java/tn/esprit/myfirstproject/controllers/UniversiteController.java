package tn.esprit.myfirstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.myfirstproject.entities.Universite;
import tn.esprit.myfirstproject.services.IUniversiteServices;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/universite")
@RequiredArgsConstructor
public class UniversiteController {

    IUniversiteServices iUniversiteService;

    @GetMapping("/afficheruniversites")
    List<Universite> retrieveAllUniversites() {
        return iUniversiteService.retrieveAllUniversites();
    }

    @PostMapping("/ajouteruniversite")
    Universite addUniversite(@RequestBody Universite c) {
        return iUniversiteService.addUniversite(c);
    }

    @PutMapping("/modifieruniversite")
    Universite updateUniversite(@RequestBody Universite c) {
        return iUniversiteService.updateUniversite(c);
    }

    @GetMapping("/afficheruniversite/{iduniversite}")
    Universite retrieveUniversite(@PathVariable("iduniversite") long idUniversite) {
        return iUniversiteService.retrieveUniversite(idUniversite);
    }

    @PutMapping("/affecterfoyerauniversite/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable("idFoyer") long idFoyer, @PathVariable("nomUniversite") String nomUniversite) {
        return iUniversiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    ;

    @PutMapping("/desaffecterfoyerauniversite/{idFoyer}/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable("idFoyer") long idFoyer, @PathVariable("idUniversite") Long idUniversite) {
        return iUniversiteService.desaffecterFoyerAUniversite(idFoyer, idUniversite);
    }

    ;

}
