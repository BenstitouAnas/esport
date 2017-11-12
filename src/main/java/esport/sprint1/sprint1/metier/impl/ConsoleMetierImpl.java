package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.ConsoleRepository;
import esport.sprint1.sprint1.metier.ConsoleMetier;
import esport.sprint1.sprint1.models.Console;
import esport.sprint1.sprint1.models.Jeu;
import esport.sprint1.sprint1.models.Tournois;
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

    @Override
    public boolean deleteConsole(Long id) {
        consoleRepository.delete(id);
        return true;
    }

    @Override
    public Console getConsole(Long id) {
        return consoleRepository.findOne(id);
    }

    @Override
    public Console updateConsole(Long id, Console c) {
        c.setId(id);
        return consoleRepository.save(c);
    }

    @Override
    public List<Jeu> getJeux(Long id) {
        return consoleRepository.findOne(id).getJeux();
    }

    @Override
    public List<Tournois> getTournois(Long id) {
        return consoleRepository.findOne(id).getTournois();
    }
}
