package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Ville;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VilleRepository extends JpaRepository<Ville, Long> {

    @Query("select v from Ville v where v.nom like :mot")
    Page<Ville> chercherVille(@Param("mot") String mot, Pageable pageable);
}
