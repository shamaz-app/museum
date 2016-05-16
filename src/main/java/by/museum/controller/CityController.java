package by.museum.controller;

import by.museum.entities.address.City;
import by.museum.service.address.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shamaz on 15.05.2016.
 */
@RestController
@RequestMapping("/city")
public class CityController extends GenericController<City, CityService>{

    @Autowired
    public CityController(CityService service) {
        super(service);
    }
}
