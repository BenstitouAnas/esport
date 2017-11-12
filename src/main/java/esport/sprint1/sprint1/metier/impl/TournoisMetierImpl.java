package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.TournoisRepository;
import esport.sprint1.sprint1.metier.TournoisMetier;
import esport.sprint1.sprint1.models.Tournois;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private TournoisRepository tournoisRepository;


}
