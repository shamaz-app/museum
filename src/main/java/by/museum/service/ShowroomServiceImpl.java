package by.museum.service;

import by.museum.entities.Showroom;
import by.museum.repositories.ShowroomRepository;
import by.museum.service.templates.SimpleService;
import by.museum.service.templates.SimpleServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shamaz on 11.05.2016.
 */
@Service
public class ShowroomServiceImpl extends SimpleServiceImpl<Showroom, ShowroomRepository> implements ShowroomService{

    public List<Showroom> getShowroomsByMuseumId(Long museumId) {
        return repository.getByMuseumId(museumId);
    }
}
