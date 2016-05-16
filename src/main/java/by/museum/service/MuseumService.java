package by.museum.service;

import by.museum.entities.MuseumBuild;
import by.museum.service.templates.NamedService;

import java.util.List;

/**
 * Created by shamaz on 06.05.2016.
 */
public interface MuseumService extends NamedService<MuseumBuild> {

    public List<MuseumBuild> getMuseumListByCityId(Long cityId);
}
