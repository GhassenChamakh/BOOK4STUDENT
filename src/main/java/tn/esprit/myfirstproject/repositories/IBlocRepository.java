package tn.esprit.myfirstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.myfirstproject.entities.Bloc;

import java.util.List;

public interface IBlocRepository extends JpaRepository<Bloc, Long> {
    @Query("SELECT b FROM Bloc b WHERE b.foyers.idFoyer = :idFoyer")
    List<Bloc> findAllByFoyerId(@Param("idFoyer") Long idFoyer);
    Bloc findBlocByNomBloc(String nom); // en utilisant keywords

    @Query("select b from Bloc b where b.nomBloc=:nom")
        // utilisant JPQL
    Bloc findBlocByNomBlocs(@Param("nom") String nom); //

}
