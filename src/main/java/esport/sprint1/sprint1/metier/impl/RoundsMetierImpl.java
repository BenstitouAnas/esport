package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.ConsoleRepository;
import esport.sprint1.sprint1.dao.RoundRepository;
import esport.sprint1.sprint1.metier.RoundsMetier;
import esport.sprint1.sprint1.models.Console;
import esport.sprint1.sprint1.models.Rounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundsMetierImpl implements RoundsMetier {
    @Autowired
    private RoundRepository roundRepository;

    @Override
    public Rounds saveRound(Rounds R) {
        return roundRepository.save(R);
    }
}
