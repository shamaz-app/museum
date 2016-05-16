package by.museum.service.address;

import by.museum.entities.address.StreetType;
import by.museum.repositories.address.StreetTypeRepository;
import by.museum.service.templates.NamedServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Анастасия on 16.05.2016.
 */
@Service
public class StreetTypeServiceImpl extends NamedServiceImpl<StreetType, StreetTypeRepository> implements StreetTypeService {
}
