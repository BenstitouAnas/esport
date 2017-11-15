package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Console;
import esport.sprint1.sprint1.models.Jeu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JeuMetier {
    Jeu saaveJeu(Jeu j);
    List<Jeu> listJeux();
    boolean deleteJeu(Long id);
    Jeu getJeu(Long id);
    Jeu updateJeu(Long id, Jeu j);

    List<Console> getConsoles(Long id);

    Page<Jeu> chercherJeu(String mot, Pageable pageable);
}
