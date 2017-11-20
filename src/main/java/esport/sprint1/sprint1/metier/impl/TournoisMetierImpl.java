package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.TournoisRepository;
import esport.sprint1.sprint1.metier.TournoisMetier;
import esport.sprint1.sprint1.models.Local;
import esport.sprint1.sprint1.models.Tournois;
import esport.sprint1.sprint1.models.TournoisEnEquipe;
import esport.sprint1.sprint1.models.TournoisIndividuel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournoisMetierImpl implements TournoisMetier {

    @Override
    public Tournois saveTournois(Tournois tournois) {
        return tournoisRepository.save(tournois);
    }

    @Override
    public List<Tournois> listTOurnois() {
        return tournoisRepository.findAll();
    }
    @Override
    public boolean exists(Tournois T) {
        return getTournois(T.getId()) != null;
    }
    @Override
    public boolean deleteTournois(Long id) {
        tournoisRepository.delete(id);
        return true;
    }

    @Override
    public Tournois updateTournois(Long id, Tournois tournois) {
        tournois.setId(id);
        return tournoisRepository.save(tournois);
    }

    @Override
    public Tournois getTournois(Long id) {
        return tournoisRepository.findOne(id);
    }

    @Override
    public Page<Tournois> chercherTournois(String mot, Pageable pageable) {
        return tournoisRepository.chercherTournois(mot, pageable);
    }

    @Override
    public Tournois publierTournois(Long id) {
        return tournoisRepository.publierTournois(id);
    }

    @Override
    public Tournois publierTournoisHorsLigne(Long idTournois, Local local) {
        return tournoisRepository.publierTournoisHorsLigne(idTournois, local);
    }

    @Override
    public Page<TournoisIndividuel> getAllTournoisIndividuel(Pageable pageable) {
        return tournoisRepository.getAllTournoisIndividuel(pageable);
    }

    @Override
    public Page<TournoisEnEquipe> getAllTournoisEnEquipe(Pageable pageable) {
        return tournoisRepository.getAllTournoisEnEquipe(pageable);
    }

    @Autowired
    private TournoisRepository tournoisRepository;


}
