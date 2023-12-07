package tn.esprit.myfirstproject.services;

import tn.esprit.myfirstproject.entities.Bloc;
import tn.esprit.myfirstproject.entities.Foyer;

import java.util.List;

public interface IFoyerServices {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer(Foyer b);

    Foyer updateFoyer(Foyer b);

    Foyer retrieveFoyer(long idFoyer);

    void removeFoyer(long idFoyer);

    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer);

    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);

}
