package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.JournalisteMetier;
import esport.sprint1.sprint1.models.Actualite;
import esport.sprint1.sprint1.models.Journaliste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class JournalisteRestService {

    @Autowired
    private JournalisteMetier journalisteMetier;

    @RequestMapping(value = "/journalistes", method = RequestMethod.POST)
    public Journaliste saveJournaliste(@RequestBody Journaliste J) {
        return journalisteMetier.saveJournaliste(J);
    }

    @RequestMapping(value = "/journalistes", method = RequestMethod.GET)
    public List<Journaliste> listJournalistes() {
        return journalisteMetier.listJournalistes();
    }

    @RequestMapping(value = "/journalistes/{id}", method = RequestMethod.DELETE)
    public boolean deleteJournaliste(@PathVariable Long id) {
        return journalisteMetier.deleteJournaliste(id);
    }

    @RequestMapping(value = "/journalistes/{id}", method = RequestMethod.GET)
    public Journaliste getJournaliste(@PathVariable Long id) {
        return journalisteMetier.getJournaliste(id);
    }

    @RequestMapping(value = "/journalistes/{id}", method = RequestMethod.PUT)
    public Journaliste updateJournaliste(@PathVariable Long id, @RequestBody Journaliste J) {
        return journalisteMetier.updateJournaliste(id, J);
    }

    @RequestMapping(value = "/journalistes/chercher", method = RequestMethod.GET)
    public Page<Journaliste> chercherJounaliste(
            @RequestParam(name = "mot", defaultValue = "") String mot,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        return journalisteMetier.chercherJounaliste("%" + mot + "%", new PageRequest(page, size));
    }

    @RequestMapping(value = "/journalistes/{id}/actuialites")
    public List<Actualite> getActualites(@PathVariable Long id) {
        return journalisteMetier.getActualites(id);
    }
}
