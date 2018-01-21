package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.UtilisateurMetier;
import esport.sprint1.sprint1.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UtilisateurRestService {

    @Autowired
    private UtilisateurMetier utilisateurMetier;

    @RequestMapping(value = "/utilisateur", method = RequestMethod.POST)
    public Utilisateur saveUtilisateur(@RequestBody Utilisateur o) {
        return utilisateurMetier.saveUtilisateur(o);
    }

    @RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
    public List<Utilisateur> listUtilisateurs() {
        return utilisateurMetier.listUtilisateurs();
    }

    public boolean deleteUtilisateur(Long id) {
        return utilisateurMetier.deleteUtilisateur(id);
    }

    @RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.GET)
    public Utilisateur getUtilisateur(@PathVariable Long id) {
        return utilisateurMetier.getUtilisateur(id);
    }

    @RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.PUT)
    public Utilisateur updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        return utilisateurMetier.updateUtilisateur(id, utilisateur);
    }

    @RequestMapping(value = "utilisateur/chercher/{userName}")
    public Utilisateur findByUserName(@PathVariable String userName) {
        return utilisateurMetier.findByUserName(userName);
    }
}
