package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.ConsoleRepository;
import esport.sprint1.sprint1.metier.ConsoleMetier;
import esport.sprint1.sprint1.models.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleMetierImpl implements ConsoleMetier {

    @Autowired
    private ConsoleRepository consoleRepository;

    @Override
    public Console saveConsole(Console c) {
        return consoleRepository.save(c);
    }

    @Override
    public List<Console> listConsoles() {
        return consoleRepository.findAll();
    }
}
