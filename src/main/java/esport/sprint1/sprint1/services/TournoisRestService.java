package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.LocalMetier;
import esport.sprint1.sprint1.metier.TournoisMetier;
import esport.sprint1.sprint1.models.Local;
import esport.sprint1.sprint1.models.Tournois;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TournoisRestService {

    @Autowired
    private TournoisMetier tournoisMetier;

    @Autowired
    private LocalMetier localMetier;

    @RequestMapping(value = "/tournois", method = RequestMethod.POST)
    public Tournois saveTournois(@RequestBody Tournois tournois) {
        return tournoisMetier.saveTournois(tournois);
    }

    @RequestMapping(value = "/tournois", method = RequestMethod.GET)
    public List<Tournois> listTOurnois() {
        return tournoisMetier.listTOurnois();
    }

    @RequestMapping(value = "/tournois/{id}", method = RequestMethod.DELETE)
    public boolean deleteTournois(@PathVariable Long id) {
        return tournoisMetier.deleteTournois(id);
    }

    @RequestMapping(value = "/tournois/{id}", method = RequestMethod.PUT)
    public Tournois updateTournois(@PathVariable Long id, @RequestBody Tournois tournois) {
        Local l = new Local(tournois.getLocal().getLatitude(), tournois.getLocal().getLongitude());
        boolean nvLocal = localMetier.isExistLocal(l.getLatitude(), l.getLongitude());

        if(nvLocal == false){
            localMetier.saveLocal(l);
            tournois.setLocal(l);
        }

        return tournoisMetier.updateTournois(id, tournois);
    }

    @RequestMapping(value = "/tournois/{id}", method = RequestMethod.GET)
    public Tournois getTournois(@PathVariable Long id) {
        return tournoisMetier.getTournois(id);
    }
}
