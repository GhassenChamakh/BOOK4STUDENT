package tn.esprit.myfirstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.myfirstproject.entities.Etudiant;
@Repository

public interface IEtudiantRepository extends JpaRepository<Etudiant, Long>  {
    Etudiant findByCin(Long cin);
}
