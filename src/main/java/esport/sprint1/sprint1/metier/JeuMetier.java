package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Jeu;

import java.util.List;

public interface JeuMetier {
    Jeu saaveJeu(Jeu j);
    List<Jeu> listJeux();
}
