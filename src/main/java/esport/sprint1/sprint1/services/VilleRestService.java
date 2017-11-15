package esport.sprint1.sprint1.services;


import esport.sprint1.sprint1.metier.VilleMetier;
import esport.sprint1.sprint1.models.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class VilleRestService {

    @RequestMapping(value = "/villes/{id}", method = RequestMethod.DELETE)
    public boolean deleteVille(@PathVariable Long id) {
        return villeMetier.deleteVille(id);
    }

    @Autowired
    private VilleMetier villeMetier;

    @RequestMapping(value = "/villes", method = RequestMethod.POST)
    public Ville saveVille(@RequestBody Ville v) {
        return villeMetier.saveVille(v);
    }

    @RequestMapping(value = "/villes", method = RequestMethod.GET)
    public List<Ville> listVilles() {
        return villeMetier.listVilles();
    }

    @RequestMapping(value = "/villes/{id}", method = RequestMethod.GET)
    public Ville getVille(@PathVariable Long id) {
        return villeMetier.getVille(id);
    }

    @RequestMapping(value = "/villes/{id}", method = RequestMethod.PUT)
    public Ville updateVille(@PathVariable Long id, @RequestBody Ville v) {
        return villeMetier.updateVille(id, v);
    }

    @RequestMapping(value = "/villes/chercher", method = RequestMethod.GET)
    public Page<Ville> chercherVille(
            @RequestParam(name = "mot", defaultValue = "") String mot,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        return villeMetier.chercherVille("%" + mot + "%", new PageRequest(page, size));
    }
}
