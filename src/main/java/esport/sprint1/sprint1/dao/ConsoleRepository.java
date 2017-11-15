package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Console;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsoleRepository extends JpaRepository<Console, Long>{

    @Query("select c from Console c where c.nom like :mot")
    Page<Console> chercherConsole(@Param("mot") String mot, Pageable pageable);
}
