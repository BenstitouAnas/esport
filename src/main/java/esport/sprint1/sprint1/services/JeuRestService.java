package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.JeuMetier;
import esport.sprint1.sprint1.models.Jeu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private JeuMetier jeuMetier;
}
