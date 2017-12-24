package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.JoueurMetier;
import esport.sprint1.sprint1.models.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class JoueurRestService {

    @RequestMapping(value = "/Joueurs", method = RequestMethod.POST)
    public Joueur saveJoueur(@RequestBody Joueur o) {
        return JoueurMetier.saveJoueur(o);
    }

    @RequestMapping(value = "/Joueurs", method = RequestMethod.GET)
    public List<Joueur> listJoueurs() {
        return JoueurMetier.listJoueurs();
    }

    @RequestMapping(value = "/Joueurs/{id}", method = RequestMethod.DELETE)
    public boolean deleteJoueur(@PathVariable Long id) {
        return JoueurMetier.deleteJoueur(id);
    }

    @RequestMapping(value = "/Joueurs/{id}", method = RequestMethod.GET)
    public Joueur getJoueur(@PathVariable Long id) {
        return JoueurMetier.getJoueur(id);
    }

    @RequestMapping(value = "/Joueurs/{id}", method = RequestMethod.PUT)
    public Joueur updateJoueur(@PathVariable Long id, @RequestBody Joueur Joueur) {
        return JoueurMetier.updateJoueur(id, Joueur);
    }

    @Autowired
    private JoueurMetier JoueurMetier;
}
