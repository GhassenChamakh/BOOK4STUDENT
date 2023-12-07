package tn.esprit.myfirstproject.services;

import tn.esprit.myfirstproject.entities.Universite;

import java.util.List;

public interface IUniversiteServices {
    List<Universite> retrieveAllUniversites();

    Universite addUniversite(Universite b);

    Universite updateUniversite(Universite b);

    Universite retrieveUniversite(long idUniversite);

    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite);
}