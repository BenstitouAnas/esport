package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.JeuRepository;
import esport.sprint1.sprint1.metier.JeuMetier;
import esport.sprint1.sprint1.models.Jeu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JeuMetierImpl implements JeuMetier {

    @Autowired
    private JeuRepository jeuRepository;

    @Override
    public Jeu saaveJeu(Jeu j) {
        return jeuRepository.save(j);
    }

    @Override
    public List<Jeu> listJeux() {
        return jeuRepository.findAll();
    }
}
