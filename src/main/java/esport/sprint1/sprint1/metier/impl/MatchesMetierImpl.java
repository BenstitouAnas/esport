package esport.sprint1.sprint1.metier.impl;

import esport.sprint1.sprint1.dao.MatchesRepository;
import esport.sprint1.sprint1.dao.RoundRepository;
import esport.sprint1.sprint1.metier.MatchesMetier;
import esport.sprint1.sprint1.models.Matches;
import esport.sprint1.sprint1.models.Rounds;
import org.springframework.beans.factory.annotation.Autowired;

public class MatchesMetierImpl implements MatchesMetier {
    @Autowired
    private MatchesRepository matchesRepository;

    @Override
    public Matches saveMatches(Matches M) {
        return matchesRepository.save(M);
    }
}
