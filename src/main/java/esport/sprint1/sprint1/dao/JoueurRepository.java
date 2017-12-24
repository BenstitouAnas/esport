package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Joueur;
import esport.sprint1.sprint1.models.Local;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
}
