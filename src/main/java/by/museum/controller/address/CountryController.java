package by.museum.controller.address;

import by.museum.controller.GenericController;
import by.museum.entities.address.Country;
import by.museum.service.address.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Анастасия on 16.05.2016.
 */
@RestController
@RequestMapping("/country")
public class CountryController extends GenericController<Country, CountryService> {

    @Autowired
    public CountryController(CountryService service) {
        super(service);
    }
}
