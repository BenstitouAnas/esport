package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.ConsoleMetier;
import esport.sprint1.sprint1.models.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsoleRestService {

    @RequestMapping(value = "/consoles", method = RequestMethod.POST)
    public Console saveConsole(@RequestBody Console c) {
        return consoleMetier.saveConsole(c);
    }

    @RequestMapping(value = "/consoles", method = RequestMethod.GET)
    public List<Console> listConsoles() {
        return consoleMetier.listConsoles();
    }

    @Autowired
    private ConsoleMetier consoleMetier;


}
