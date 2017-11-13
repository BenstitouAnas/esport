package esport.sprint1.sprint1.dao;

import esport.sprint1.sprint1.models.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocalRepository extends JpaRepository<Local, Long> {

    @Query("select l from Local l where  l.latitude = :lat and l.longitude = :lon")
    Local isExistLocal(@Param("lat") double lat, @Param("lon") double lon);
}
