package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.UtilisateurRepository;
import esport.sprint1.sprint1.metier.UtilisateurMetier;
import esport.sprint1.sprint1.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurImpl implements UtilisateurMetier {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur saveUtilisateur(Utilisateur o) {
        return utilisateurRepository.save(o);
    }

    @Override
    public List<Utilisateur> listUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public boolean deleteUtilisateur(Long id) {
        utilisateurRepository.delete(id);
        return true;
    }

    @Override
    public Utilisateur getUtilisateur(Long id) {
        return utilisateurRepository.findOne(id);
    }

    @Override
    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur) {
        return null;
    }

    @Override
    public Utilisateur findByUserName(String userName) {
        return utilisateurRepository.findByNomUtilisateur(userName);
    }
}
