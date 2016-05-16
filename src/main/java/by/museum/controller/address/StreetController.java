package by.museum.controller.address;

import by.museum.controller.GenericController;
import by.museum.entities.address.City;
import by.museum.entities.address.Street;
import by.museum.service.address.CityService;
import by.museum.service.address.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by Анастасия on 16.05.2016.
 */
@RestController
@RequestMapping("/street")
public class StreetController extends GenericController<Street, StreetService> {

    @Autowired
    public StreetController(StreetService service) {
        super(service);
    }

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/cityId/{cityId}", method = RequestMethod.GET)
    public Set<Street> getStreetsByCityId(@PathVariable("cityId") Long cityId) {
        return cityService.get(cityId).getStreets();
    }
}
