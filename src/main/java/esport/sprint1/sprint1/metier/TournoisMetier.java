package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Tournois;

import java.util.List;

public interface TournoisMetier {
    Tournois saveTournois(Tournois tournois);
    List<Tournois> listTOurnois();
    boolean deleteTournois(Long id);
    Tournois updateTournois(Long id, Tournois tournois);
    Tournois getTournois(Long id);
}
