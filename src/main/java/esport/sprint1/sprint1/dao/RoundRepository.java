package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Rounds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoundRepository extends JpaRepository<Rounds, Long> {
}
