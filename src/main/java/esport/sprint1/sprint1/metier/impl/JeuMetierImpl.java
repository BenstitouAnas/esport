package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.JeuRepository;
import esport.sprint1.sprint1.metier.JeuMetier;
import esport.sprint1.sprint1.models.Console;
import esport.sprint1.sprint1.models.Jeu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public boolean deleteJeu(Long id) {
        jeuRepository.delete(id);
        return true;
    }

    @Override
    public Jeu getJeu(Long id) {
        return jeuRepository.findOne(id);
    }

    @Override
    public Jeu updateJeu(Long id, Jeu j) {
        j.setId(id);
        return jeuRepository.save(j);
    }

    @Override
    public Page<Jeu> chercherJeu(String mot, Pageable pageable) {
        return jeuRepository.chercherJeu(mot, pageable);
    }

    @Override
    public List<Console> getConsoles(Long id) {
        return jeuRepository.findOne(id).getConsoles();
    }
}
