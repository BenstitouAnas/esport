package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.OrganisateurRepository;
import esport.sprint1.sprint1.metier.OrganisateurMetier;
import esport.sprint1.sprint1.models.Organisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisateurMetierImpl implements OrganisateurMetier{

    @Autowired
    private OrganisateurRepository organisateurRepository;

    @Override
    public Organisateur saveOrganisateur(Organisateur o) {
        return organisateurRepository.save(o);
    }

    @Override
    public List<Organisateur> listOrganisateurs() {
        return organisateurRepository.findAll();
    }

    @Override
    public boolean deleteOrganisateur(Long id) {
        organisateurRepository.delete(id);
        return true;
    }

    @Override
    public Organisateur getOrganisateur(Long id) {
        return organisateurRepository.findOne(id);
    }

    @Override
    public Organisateur updateOrganisateur(Long id, Organisateur organisateur) {
        organisateur.setId(id);
        return organisateurRepository.save(organisateur);
    }
}
