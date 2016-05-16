package by.museum.service.address;

import by.museum.entities.address.CityType;
import by.museum.repositories.address.CityTypeRepository;
import by.museum.service.templates.NamedServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Анастасия on 16.05.2016.
 */
@Service
public class CityTypeServiceImpl extends NamedServiceImpl<CityType, CityTypeRepository> implements CityTypeService{
}
