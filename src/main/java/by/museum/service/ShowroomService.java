package by.museum.service;

import by.museum.entities.Showroom;
import by.museum.service.templates.NamedService;
import by.museum.service.templates.SimpleService;

import java.util.List;

/**
 * Created by shamaz on 11.05.2016.
 */
public interface ShowroomService extends SimpleService<Showroom> {

    List<Showroom> getShowroomsByMuseumId(Long museumId);
}
