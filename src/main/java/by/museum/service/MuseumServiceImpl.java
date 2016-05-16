package by.museum.service;

import by.museum.entities.MuseumBuild;
import by.museum.repositories.MuseumBuildRepository;
import by.museum.service.templates.NamedServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shamaz on 06.05.2016.
 */
@Service
public class MuseumServiceImpl extends NamedServiceImpl<MuseumBuild, MuseumBuildRepository> implements MuseumService {


    public List<MuseumBuild> getMuseumListByCityId(Long cityId) {
        return repository.getMuseumListByCityId(cityId);
    }
}
