package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Jeu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JeuRepository extends JpaRepository<Jeu, Long> {

    @Query("select j from Jeu j where j.nom like :mot")
    Page<Jeu> chercherJeu(@Param("mot") String mot, Pageable pageable);
}
