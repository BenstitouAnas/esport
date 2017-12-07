package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Actualite;

import java.util.List;

public interface ActualiteMetier {
    Actualite saveActualite(Actualite T);
    List<Actualite> listActualite();
    boolean deleteActualite(Long id);
    Actualite getActualite(Long id);
    Actualite updateActualite(Long id, Actualite c);
}
