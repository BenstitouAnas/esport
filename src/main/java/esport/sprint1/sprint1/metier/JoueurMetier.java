package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Joueur;

import java.util.List;

public interface JoueurMetier {
    Joueur saveJoueur(Joueur o);
    List<Joueur> listJoueurs();
    boolean deleteJoueur(Long id);
    Joueur getJoueur(Long id);
    Joueur updateJoueur(Long id, Joueur Joueur);
}
