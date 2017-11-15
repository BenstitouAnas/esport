package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.ConsoleMetier;
import esport.sprint1.sprint1.models.Console;
import esport.sprint1.sprint1.models.Jeu;
import esport.sprint1.sprint1.models.Tournois;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ConsoleRestService {

    @RequestMapping(value = "/consoles", method = RequestMethod.POST)
    public Console saveConsole(@RequestBody Console c) {
        return consoleMetier.saveConsole(c);
    }

    @RequestMapping(value = "/consoles", method = RequestMethod.GET)
    public List<Console> listConsoles() {
        return consoleMetier.listConsoles();
    }

    @RequestMapping(value = "/consoles/{id}", method = RequestMethod.DELETE)
    public boolean deleteConsole(@PathVariable Long id) {
        return consoleMetier.deleteConsole(id);
    }

    @RequestMapping(value = "/consoles/{id}", method = RequestMethod.GET)
    public Console getConsole(@PathVariable Long id) {
        return consoleMetier.getConsole(id);
    }

    @RequestMapping(value = "/consoles/{id}", method = RequestMethod.PUT)
    public Console updateConsole(@PathVariable Long id,  @RequestBody Console c) {
        return consoleMetier.updateConsole(id, c);
    }

    @RequestMapping(value = "/consoles/{id}/jeux", method = RequestMethod.GET)
    public List<Jeu> getJeux(@PathVariable Long id) {
        return consoleMetier.getJeux(id);
    }

    @RequestMapping(value = "/consoles/{id}/tournois", method = RequestMethod.GET)
    public List<Tournois> getTournois(@PathVariable Long id) {
        return consoleMetier.getTournois(id);
    }

    @RequestMapping(value = "/consoles/chercher", method = RequestMethod.GET)
    public Page<Console> chercherConsole(
            @RequestParam(name = "mot", defaultValue = "") String mot,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        return consoleMetier.chercherConsole("%" + mot + "%", new PageRequest(page, size));
    }

    @Autowired
    private ConsoleMetier consoleMetier;


}
