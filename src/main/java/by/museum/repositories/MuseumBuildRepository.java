package by.museum.repositories;

import by.museum.entities.MuseumBuild;
import by.museum.repositories.template.NamedRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by shamaz on 06.05.2016.
 */
public interface MuseumBuildRepository extends NamedRepository<MuseumBuild> {

    @Query("SELECT m " +
            "FROM MuseumBuild m " +
            "JOIN m.street s " +
            "JOIN s.city c " +
            "WHERE c.id = :cityId"
           )
    List<MuseumBuild> getMuseumListByCityId(@Param("cityId") Long id);

}
