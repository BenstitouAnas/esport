package esport.sprint1.sprint1.metier;

import esport.sprint1.sprint1.models.Organisateur;

import java.util.List;

public interface OrganisateurMetier {
    Organisateur saveOrganisateur(Organisateur o);
    List<Organisateur> listOrganisateurs();
}
