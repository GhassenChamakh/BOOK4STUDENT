package tn.esprit.myfirstproject.services;

import tn.esprit.myfirstproject.entities.Chambre;
import tn.esprit.myfirstproject.entities.TypeChambre;

import java.util.List;

public interface IChambreServices {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre(Chambre c);

    Chambre retrieveChambre(long idChambre);

    void removeChambre(long idChambre);

    List<Chambre> getChambreByNomBloc(String nom);
    List<Chambre> getChambreByType(TypeChambre type);

    long nbChambreParTypeEtBloc(TypeChambre type, long idBloc);

    public List<Chambre> getChambresParNomUniversite(String nomUniversite);

    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);

    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(
            String nomUniversite, TypeChambre type);


}
