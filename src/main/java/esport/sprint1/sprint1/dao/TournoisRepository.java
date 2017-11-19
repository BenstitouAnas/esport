package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Local;
import esport.sprint1.sprint1.models.Tournois;
import esport.sprint1.sprint1.models.TournoisEnEquipe;
import esport.sprint1.sprint1.models.TournoisIndividuel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TournoisRepository extends JpaRepository<Tournois, Long> {

    @Query("select t from Tournois t where t.titre like :mot")
    Page<Tournois> chercherTournois(@Param("mot") String mot, Pageable pageable);

    @Modifying
    @Query("update Tournois t set t.publie = true where t.id = :idT")
    Tournois publierTournois(@Param("idT") Long idTournois);

    @Query("select t from Tournois t where type(t) = TournoisIndividuel")
    Page<TournoisIndividuel> getAllTournoisIndividuel(Pageable pageable);

    @Query("select t from Tournois t where type(t) = TournoisEnEquipe")
    Page<TournoisEnEquipe> getAllTournoisEnEquipe(Pageable pageable);

    @Query("update Tournois t set publie = true, t.local = :local where t.id = :idT")
    Tournois publierTournoisHorsLigne(@Param("idT") Long idTournois, @Param("local")Local local);
}
