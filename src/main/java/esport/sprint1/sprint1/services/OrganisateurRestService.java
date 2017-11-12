package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.OrganisateurMetier;
import esport.sprint1.sprint1.models.Organisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrganisateurRestService {

    @RequestMapping(value = "/organisateurs", method = RequestMethod.POST)
    public Organisateur saveOrganisateur(@RequestBody Organisateur o) {
        return organisateurMetier.saveOrganisateur(o);
    }

    @RequestMapping(value = "/organisateurs", method = RequestMethod.GET)
    public List<Organisateur> listOrganisateurs() {
        return organisateurMetier.listOrganisateurs();
    }

    @Autowired
    private OrganisateurMetier organisateurMetier;
}
