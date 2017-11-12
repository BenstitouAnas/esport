package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Console;
import esport.sprint1.sprint1.models.Jeu;
import esport.sprint1.sprint1.models.Tournois;

import java.util.List;

public interface ConsoleMetier {
    Console saveConsole(Console c);
    List<Console> listConsoles();
    boolean deleteConsole(Long id);
    Console getConsole(Long id);
    Console updateConsole(Long id, Console c);

    List<Jeu> getJeux(Long id);
    List<Tournois> getTournois(Long id);
}
