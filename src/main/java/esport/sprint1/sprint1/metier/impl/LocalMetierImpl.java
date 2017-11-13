package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.LocalRepository;
import esport.sprint1.sprint1.metier.LocalMetier;
import esport.sprint1.sprint1.models.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalMetierImpl implements LocalMetier {

    @Autowired
    private LocalRepository localRepository;

    @Override
    public Local saveLocal(Local l) {
        return localRepository.save(l);
    }

    @Override
    public List<Local> listLocales() {
        return localRepository.findAll();
    }

    @Override
    public boolean deleteLocal(Long id) {
        localRepository.delete(id);
        return true;
    }

    @Override
    public Local getLocal(Long id) {
        return localRepository.findOne(id);
    }

    @Override
    public Local updateLocal(Long id, Local l) {
        l.setId(id);
        return localRepository.save(l);
    }

    @Override
    public boolean isExistLocal(double lat, double lon) {
        Local l = localRepository.isExistLocal(lat, lon);
        if(l != null)
            return true;
        return false;
    }
}
