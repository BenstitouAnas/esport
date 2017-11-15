package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.JeuMetier;
import esport.sprint1.sprint1.models.Console;
import esport.sprint1.sprint1.models.Jeu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
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

    @RequestMapping(value = "/jeux/{id}", method = RequestMethod.PUT)
    public Jeu updateJeu(@PathVariable Long id,  @RequestBody Jeu j) {
        return jeuMetier.updateJeu(id, j);
    }

    @RequestMapping(value = "/jeux/{id}/consoles", method = RequestMethod.GET)
    public List<Console> getConsoles(@PathVariable Long id) {
        return jeuMetier.getConsoles(id);
    }

    @RequestMapping(value = "/jeux/chercher", method = RequestMethod.GET)
    public Page<Jeu> chercherJeu(
            @RequestParam(name = "mot", defaultValue = "") String mot,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        return jeuMetier.chercherJeu("%" + mot + "%", new PageRequest(page, size));
    }

    @Autowired
    private JeuMetier jeuMetier;
}
