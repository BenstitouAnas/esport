package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Tournois;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TournoisRepository extends JpaRepository<Tournois, Long> {

    //@Query("")
   // Tournois publierTournoisHorsLigne(Long idTournois, Long idLocal);
}
