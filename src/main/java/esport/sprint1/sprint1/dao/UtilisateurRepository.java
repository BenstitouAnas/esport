package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query("select c from Utilisateur c where c.nomUtilisateur like :mot")
    Utilisateur findByNomUtilisateur(@Param("mot") String mot);
}
