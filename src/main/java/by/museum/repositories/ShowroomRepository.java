package by.museum.repositories;

import by.museum.entities.Showroom;
import by.museum.repositories.template.NamedRepository;
import by.museum.repositories.template.SimpleRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by shamaz on 06.05.2016.
 */
public interface ShowroomRepository extends SimpleRepository<Showroom> {

    @Query("SELECT sh " +
            "FROM Showroom sh " +
            "JOIN sh.museum m " +
            "WHERE m.id = :museumId"
    )
    List<Showroom> getByMuseumId(@Param("museumId") Long museumId);
}
