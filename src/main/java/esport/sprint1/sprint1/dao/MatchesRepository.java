package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Matches;
import esport.sprint1.sprint1.models.Rounds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchesRepository extends JpaRepository<Matches, Long> {
}
