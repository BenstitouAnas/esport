package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.ConsoleMetier;
import esport.sprint1.sprint1.models.Console;
import esport.sprint1.sprint1.models.Jeu;
import esport.sprint1.sprint1.models.Tournois;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ConsoleMetier consoleMetier;


}
