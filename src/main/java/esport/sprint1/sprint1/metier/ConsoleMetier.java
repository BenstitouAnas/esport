package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Console;

import java.util.List;

public interface ConsoleMetier {
    Console saveConsole(Console c);
    List<Console> listConsoles();
}
