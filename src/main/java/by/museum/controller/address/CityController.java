package by.museum.controller.address;

import by.museum.controller.GenericController;
import by.museum.entities.MuseumBuild;
import by.museum.entities.address.City;
import by.museum.service.address.CityService;
import by.museum.service.address.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by shamaz on 15.05.2016.
 */
@RestController
@RequestMapping("/city")
public class CityController extends GenericController<City, CityService> {

    @Autowired
    public CityController(CityService service) {
        super(service);
    }

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/countryId/{countryId}", method = RequestMethod.GET)
    public Set<City> getCityListByContryId(@PathVariable("countryId") Long countryId) {
        return countryService.get(countryId).getCities();
    }
}
