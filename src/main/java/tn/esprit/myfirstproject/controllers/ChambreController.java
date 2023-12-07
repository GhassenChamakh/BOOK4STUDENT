package tn.esprit.myfirstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.myfirstproject.entities.Chambre;
import tn.esprit.myfirstproject.entities.TypeChambre;
import tn.esprit.myfirstproject.services.IChambreServices;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/chambre")
@RequiredArgsConstructor
public class ChambreController {

    IChambreServices iChambreService;

    @GetMapping("/afficherchambres")
    List<Chambre> retrieveAllChambres() {
        return iChambreService.retrieveAllChambres();
    }

    @PostMapping("/ajouterchambre")
    Chambre addChambre(@RequestBody Chambre c) {
        return iChambreService.addChambre(c);
    }

    @PutMapping("/modifierchambre")
    Chambre updateChambre(@RequestBody Chambre c) {
        return iChambreService.updateChambre(c);
    }

    @GetMapping("/afficherchambre/{idchambre}")
    Chambre retrieveChambre(@PathVariable("idchambre") long idChambre) {
        return iChambreService.retrieveChambre(idChambre);
    }

    @DeleteMapping("/supprimerchambre/{idchambre}")
    String removeChambre(@PathVariable("idchambre") long idChambre) {
        iChambreService.removeChambre(idChambre);
        return ("Chambre est supprimer");
    }

    @GetMapping("/getbynombloc/{nom}")
    public List<Chambre> getChambreByNomBloc(@PathVariable("nom") String nom) {
        return iChambreService.getChambreByNomBloc(nom);
    }

    @GetMapping("/getChambresParNomUniversite/{nomuniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable("nomuniversite") String nomuniversite) {
        return iChambreService.getChambresParNomUniversite(nomuniversite);
    }

    @GetMapping("/getChambresPartype/{type}")
    public List<Chambre> getChambresParNomType(@PathVariable("type") TypeChambre type) {
        return iChambreService.getChambreByType(type);
    }
}

