package by.museum.service;

import by.museum.entities.Showpiece;
import by.museum.repositories.ShowpieceRepository;
import by.museum.service.templates.NamedServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Анастасия on 06.04.2016.
 */
@Service
public class ShowpieceServiceImpl extends NamedServiceImpl<Showpiece, ShowpieceRepository> implements ShowpieceService {

}
