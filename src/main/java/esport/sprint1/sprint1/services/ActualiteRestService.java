package esport.sprint1.sprint1.services;


import esport.sprint1.sprint1.metier.ActualiteMetier;
import esport.sprint1.sprint1.models.Actualite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ActualiteRestService {
    @RequestMapping(value = "/actualites", method = RequestMethod.POST)
    public Actualite saveActualite(@RequestBody Actualite c) {
        return actualiteMetier.saveActualite(c);
    }

    @RequestMapping(value = "/actualites", method = RequestMethod.GET)
    public List<Actualite> listactualites() {
        return actualiteMetier.listActualite();
    }

    @RequestMapping(value = "/actualites/{id}", method = RequestMethod.DELETE)
    public boolean deleteActualite(@PathVariable Long id) {
        return actualiteMetier.deleteActualite(id);
    }

    @RequestMapping(value = "/actualites/{id}", method = RequestMethod.GET)
    public Actualite getActualite(@PathVariable Long id) {
        return actualiteMetier.getActualite(id);
    }

    @RequestMapping(value = "/actualites/{id}", method = RequestMethod.PUT)
    public Actualite updateActualite(@PathVariable Long id,  @RequestBody Actualite c) {
        return actualiteMetier.updateActualite(id, c);
    }

    @Autowired
    private ActualiteMetier actualiteMetier;
}
