package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.LocalMetier;
import esport.sprint1.sprint1.metier.MatchesMetier;
import esport.sprint1.sprint1.metier.RoundsMetier;
import esport.sprint1.sprint1.metier.TournoisMetier;
import esport.sprint1.sprint1.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class TournoisRestService {

    @Autowired
    private TournoisMetier tournoisMetier;

    @Autowired
    private LocalMetier localMetier;

    @Autowired
    private RoundsMetier roundsMetier;

    @Autowired
    private MatchesMetier matchesMetier;

    @RequestMapping(value = "/tournois", method = RequestMethod.POST)
    public Tournois saveTournois(@RequestBody Tournois tournois) {
     //   System.out.print(tournois.);
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
        //Local l = new Local(tournois.getLocal().getLatitude(), tournois.getLocal().getLongitude());
        //boolean nvLocal = localMetier.isExistLocal(l.getLatitude(), l.getLongitude());

        /*if(nvLocal == false){
            localMetier.saveLocal(l);
            tournois.setLocal(l);
        }*/

     Local l = localMetier.getLocal(1L);
        tournois.setLocal(l);

        return tournoisMetier.updateTournois(id, tournois);
    }
    @RequestMapping(value = "/tournois/{id}/participer", method = RequestMethod.PUT)
    public Tournois participer(@PathVariable Long id, @RequestBody Tournois tournois) {
        return tournoisMetier.updateTournois(id, tournois);
    }


    @RequestMapping(value = "/tournois/{id}", method = RequestMethod.GET)
    public Tournois getTournois(@PathVariable Long id) {
        return tournoisMetier.getTournois(id);
    }

    @RequestMapping(value = "/tournois/chercher", method = RequestMethod.GET)
    public Page<Tournois> chercherTournois(
            @RequestParam(name = "mot", defaultValue = "") String mot,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        return tournoisMetier.chercherTournois("%" + mot + "%", new PageRequest(page, size));
    }
    @RequestMapping(value = "/tournois/{id}/generer", method = RequestMethod.POST)
    public Tournois genererTournoi(
            @PathVariable Long id)
    {
        int a = 0;
        Tournois tournois = tournoisMetier.getTournois(id);
        if(tournois instanceof TournoisIndividuel){
            a = ((TournoisIndividuel) tournois).getNbJoueurs();

        }else
       {
           a =  ((TournoisEnEquipe) tournois).getNbEquipes();

        }

        Rounds R = new Rounds();
        ArrayList<Long> T = new ArrayList<Long>();
        for(int i = 0; i < a;i++)
        {
            T.add(Long.parseLong(i+""));
        }
        R.setTournoi(tournois);
       R.StartToornament(T);
        roundsMetier.saveRound(R);
        ArrayList<Rounds> Rnd = new ArrayList<Rounds>();
        Rnd.add(R);
        matchesMetier.saveMatches(new ArrayList<>(R.getM_Matches()));
        tournois.setRound(Rnd);
        return tournois;

    }
    @RequestMapping(value = "/tournois/{id}/publier", method = RequestMethod.PUT)
    public Tournois publierTournois(
            @PathVariable Long id,
            @RequestParam(name = "lat", defaultValue = "33.706395") double lat,
            @RequestParam(name = "lng", defaultValue = "-7.353508") double lng) {
        Tournois tournois = tournoisMetier.getTournois(id);
        tournois.setPublie(true);

        if(tournois.isEnLigne() == true){
            return tournoisMetier.updateTournois(id, tournois);
        }else{
            Local l = new Local(lat, lng);
            boolean nvLocal = localMetier.isExistLocal(l.getLatitude(), l.getLongitude());

            if(nvLocal == true){
                localMetier.saveLocal(l);
            }
            tournois.setLocal(l);
            return tournoisMetier.updateTournois(id, tournois);
        }

    }

    @RequestMapping(value = "/tournois/{id}/nonpublier", method = RequestMethod.PUT)
    public Tournois nonPublierTournois(@PathVariable Long id) {
        Tournois tournois = tournoisMetier.getTournois(id);
        tournois.setPublie(false);
        return tournoisMetier.updateTournois(id, tournois);
    }

    @RequestMapping(value = "/tournois/{id}/publierHorsLigne", method =RequestMethod.PUT)
    public Tournois publierTournoisHorsLigne(
            @PathVariable Long idTournois,
            @RequestBody Local local) {
        return tournoisMetier.publierTournoisHorsLigne(idTournois, local);
    }

    @RequestMapping(value = "/tournois/individuels", method = RequestMethod.GET)
    public Page<TournoisIndividuel> getAllTournoisIndividuel(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size
    ) {
        return tournoisMetier.getAllTournoisIndividuel(new PageRequest(page, size));
    }

    @RequestMapping(value = "/tournois/enEquipes", method = RequestMethod.GET)
    public Page<TournoisEnEquipe> getAllTournoisEnEquipe(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size
    ) {
        return tournoisMetier.getAllTournoisEnEquipe(new PageRequest(page, size));
    }
}
