package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Local;
import esport.sprint1.sprint1.models.Tournois;
import esport.sprint1.sprint1.models.TournoisEnEquipe;
import esport.sprint1.sprint1.models.TournoisIndividuel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TournoisMetier {
    Tournois saveTournois(Tournois tournois);
    List<Tournois> listTOurnois();
    boolean deleteTournois(Long id);
    Tournois updateTournois(Long id, Tournois tournois);
    Tournois getTournois(Long id);
    boolean exists(Tournois T);
    Page<Tournois> chercherTournois(String mot, Pageable pageable);

    Tournois publierTournois(Long id);
    Tournois publierTournoisHorsLigne(Long idTournois, Local local);

    Page<TournoisIndividuel> getAllTournoisIndividuel(Pageable pageable);
    Page<TournoisEnEquipe> getAllTournoisEnEquipe(Pageable pageable);
}
