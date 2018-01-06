package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Actualite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActualiteRepository extends JpaRepository<Actualite, Long> {

    @Query("select a from Actualite a where a.titre like :mot")
    Page<Actualite> chercherActualite(@Param("mot") String mot, Pageable pageable);

    @Query("select a from Actualite a order by a.dateEcriture desc")
    List<Actualite> latestActs();
}
