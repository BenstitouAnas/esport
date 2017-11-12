package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.OrganisateurMetier;
import esport.sprint1.sprint1.models.Organisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganisateurRestService {

    @RequestMapping(value = "/organisateurs", method = RequestMethod.POST)
    public Organisateur saveOrganisateur(@RequestBody Organisateur o) {
        return organisateurMetier.saveOrganisateur(o);
    }

    @RequestMapping(value = "/organisateurs/list", method = RequestMethod.GET)
    public List<Organisateur> listOrganisateurs() {
        return organisateurMetier.listOrganisateurs();
    }

    @RequestMapping(value = "/organisateurs/{id}", method = RequestMethod.DELETE)
    public boolean deleteOrganisateur(@PathVariable Long id) {
        return organisateurMetier.deleteOrganisateur(id);
    }

    @RequestMapping(value = "/organisateurs/{id}", method = RequestMethod.GET)
    public Organisateur getOrganisateur(@PathVariable Long id) {
        return organisateurMetier.getOrganisateur(id);
    }

    @RequestMapping(value = "/organisateurs/{id}", method = RequestMethod.PUT)
    public Organisateur updateOrganisateur(@PathVariable Long id, @RequestBody Organisateur organisateur) {
        return organisateurMetier.updateOrganisateur(id, organisateur);
    }

    @Autowired
    private OrganisateurMetier organisateurMetier;
}
