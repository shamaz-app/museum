package by.museum.service.address;

import by.museum.entities.address.Country;
import by.museum.repositories.address.CountryRepository;
import by.museum.service.templates.NamedServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Анастасия on 16.05.2016.
 */
@Service
public class CountryServiceImpl extends NamedServiceImpl<Country, CountryRepository> implements CountryService{
}
