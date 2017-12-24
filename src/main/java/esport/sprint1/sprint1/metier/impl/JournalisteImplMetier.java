package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.JournalisteRepository;
import esport.sprint1.sprint1.metier.JournalisteMetier;
import esport.sprint1.sprint1.models.Actualite;
import esport.sprint1.sprint1.models.Journaliste;
import esport.sprint1.sprint1.models.Journaliste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JournalisteImplMetier implements JournalisteMetier {
    @Autowired
    private JournalisteRepository journalisteRepository;

    @Override
    public Journaliste saveJournaliste(Journaliste o) {
        return journalisteRepository.save(o);
    }

    @Override
    public List<Journaliste> listJournalistes() {
        return journalisteRepository.findAll();
    }

    @Override
    public boolean deleteJournaliste(Long id) {
        journalisteRepository.delete(id);
        return true;
    }

    @Override
    public Journaliste getJournaliste(Long id) {
        return journalisteRepository.findOne(id);
    }

    @Override
    public Journaliste updateJournaliste(Long id, Journaliste Journaliste) {
        Journaliste.setId(id);
        return journalisteRepository.save(Journaliste);
    }

    @Override
    public Page<Journaliste> chercherJounaliste(String mot, Pageable pageable) {
        return journalisteRepository.chercherJournaliste(mot, pageable);
    }

    @Override
    public List<Actualite> getActualites(Long id) {
        return journalisteRepository.findOne(id).getM_Acts();
    }
}
