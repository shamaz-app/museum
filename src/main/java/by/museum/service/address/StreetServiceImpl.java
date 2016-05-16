package by.museum.service.address;

import by.museum.entities.address.Street;
import by.museum.repositories.address.StreetRepository;
import by.museum.service.templates.NamedServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Анастасия on 16.05.2016.
 */
@Service
public class StreetServiceImpl extends NamedServiceImpl<Street, StreetRepository> implements StreetService{
}
