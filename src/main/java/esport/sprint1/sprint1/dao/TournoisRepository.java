package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Tournois;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournoisRepository extends JpaRepository<Tournois, Long> {
}
