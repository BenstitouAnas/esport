package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.ActualiteRepository;
import esport.sprint1.sprint1.metier.ActualiteMetier;
import esport.sprint1.sprint1.models.Actualite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActualiteMetierImpl implements ActualiteMetier {

    @Autowired
    private ActualiteRepository actualiteRepository;


    @Override
    public Actualite saveActualite(Actualite T) {
        return actualiteRepository.save(T);
    }

    @Override
    public List<Actualite> listActualite() {
        return actualiteRepository.findAll();
    }

    @Override
    public boolean deleteActualite(Long id) {
         actualiteRepository.delete(id);
         return true;
    }

    @Override
    public Actualite getActualite(Long id) {
        return actualiteRepository.findOne(id);
    }

    @Override
    public Actualite updateActualite(Long id, Actualite c) {
        c.setId(id);
        return actualiteRepository.save(c);
    }

    @Override
    public Page<Actualite> chercherActualite(String mot, Pageable pageable) {
        return this.actualiteRepository.chercherActualite(mot, pageable);
    }

    @Override
    public List<Actualite> latestActualites() {
        return actualiteRepository.latestActs();
    }
}
