package tn.esprit.myfirstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.myfirstproject.entities.Foyer;
@Repository

public interface IFoyerRepository extends JpaRepository<Foyer, Long> {
    Foyer findFoyerByNomFoyer(String nom);
}
