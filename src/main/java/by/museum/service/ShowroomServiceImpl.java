package by.museum.service;

import by.museum.entities.Showroom;
import by.museum.repositories.ShowroomRepository;
import by.museum.service.templates.SimpleService;
import by.museum.service.templates.SimpleServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by shamaz on 11.05.2016.
 */
@Service
public class ShowroomServiceImpl extends SimpleServiceImpl<Showroom, ShowroomRepository> implements ShowroomService{
}
