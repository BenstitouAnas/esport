package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Utilisateur;

import java.util.List;

public interface UtilisateurMetier {

    Utilisateur saveUtilisateur(Utilisateur o);
    List<Utilisateur> listUtilisateurs();
    boolean deleteUtilisateur(Long id);
    Utilisateur getUtilisateur(Long id);
    Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur);

    Utilisateur findByUserName(String userName);
}
