package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Journaliste;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JournalisteRepository extends JpaRepository<Journaliste, Long> {

    @Query("select c from Journaliste c where c.nom like :mot")
    Page<Journaliste> chercherJournaliste(@Param("mot") String mot, Pageable pageable);
}
