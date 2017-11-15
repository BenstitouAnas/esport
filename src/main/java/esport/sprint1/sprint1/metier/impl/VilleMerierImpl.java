package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.VilleRepository;
import esport.sprint1.sprint1.metier.VilleMetier;
import esport.sprint1.sprint1.models.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleMerierImpl implements VilleMetier {

    @Autowired
    private VilleRepository villeRepository;

    @Override
    public Ville saveVille(Ville v) {
        return villeRepository.save(v);
    }

    @Override
    public List<Ville> listVilles() {
        return villeRepository.findAll();
    }

    @Override
    public boolean deleteVille(Long id) {
        villeRepository.delete(id);
        return true;
    }

    @Override
    public Ville getVille(Long id) {
        return villeRepository.findOne(id);
    }

    @Override
    public Ville updateVille(Long id, Ville v) {
        v.setId(id);
        return villeRepository.save(v);
    }

    @Override
    public Page<Ville> chercherVille(String mot, Pageable pageable) {
        return villeRepository.chercherVille(mot, pageable);
    }
}
