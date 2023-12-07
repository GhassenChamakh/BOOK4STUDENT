package tn.esprit.myfirstproject.services;

import tn.esprit.myfirstproject.entities.Bloc;

import java.util.List;

public interface IBlocServices {
    List<Bloc> retrieveAllBlocs();

    Bloc addBloc(Bloc b);

    Bloc updateBloc(Bloc b);

    Bloc retrieveBloc(long idBloc);

    void removeBloc(long idBloc);

    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);


}
