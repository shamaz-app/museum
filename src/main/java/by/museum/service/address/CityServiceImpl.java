package by.museum.service.address;

import by.museum.entities.address.City;
import by.museum.repositories.address.CityRepository;
import by.museum.service.templates.NamedServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by shamaz on 15.05.2016.
 */
@Service
public class CityServiceImpl extends NamedServiceImpl<City, CityRepository> implements CityService {
}
