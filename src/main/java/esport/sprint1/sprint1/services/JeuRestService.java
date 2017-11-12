package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.JeuMetier;
import esport.sprint1.sprint1.models.Jeu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JeuRestService {

    @RequestMapping(value = "/jeux", method = RequestMethod.POST)
    public Jeu saaveJeu(@RequestBody Jeu j) {
        return jeuMetier.saaveJeu(j);
    }

    @RequestMapping(value = "/jeux", method = RequestMethod.GET)
    public List<Jeu> listJeux() {
        return jeuMetier.listJeux();
    }

    @RequestMapping(value = "/jeux/{id}", method = RequestMethod.DELETE)
    public boolean deleteJeu(@PathVariable Long id) {
        return jeuMetier.deleteJeu(id);
    }

    @RequestMapping(value = "/jeux/{id}", method = RequestMethod.GET)
    public Jeu getJeu(@PathVariable Long id) {
        return jeuMetier.getJeu(id);
    }

    @RequestMapping(value = "/jeux/{id}")
    public Jeu updateJeu(@PathVariable Long id,  @RequestBody Jeu j) {
        return jeuMetier.updateJeu(id, j);
    }

    @Autowired
    private JeuMetier jeuMetier;
}
