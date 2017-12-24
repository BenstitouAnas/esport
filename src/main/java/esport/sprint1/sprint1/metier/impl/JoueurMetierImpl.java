package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.JoueurRepository;
import esport.sprint1.sprint1.metier.JoueurMetier;
import esport.sprint1.sprint1.models.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JoueurMetierImpl implements JoueurMetier {

    @Autowired
    private JoueurRepository JoueurRepository;

    @Override
    public Joueur saveJoueur(Joueur o) {
        return JoueurRepository.save(o);
    }

    @Override
    public List<Joueur> listJoueurs() {
        return JoueurRepository.findAll();
    }

    @Override
    public boolean deleteJoueur(Long id) {
        JoueurRepository.delete(id);
        return true;
    }

    @Override
    public Joueur getJoueur(Long id) {
        return JoueurRepository.findOne(id);
    }

    @Override
    public Joueur updateJoueur(Long id, Joueur Joueur) {
        Joueur.setId(id);
        return JoueurRepository.save(Joueur);
    }
}
