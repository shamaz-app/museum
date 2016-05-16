package by.museum.controller.address;

import by.museum.controller.GenericController;
import by.museum.entities.address.CityType;
import by.museum.service.address.CityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Анастасия on 16.05.2016.
 */
@RestController
@RequestMapping("/cityType")
public class CityTypeController extends GenericController<CityType, CityTypeService> {

    @Autowired
    public CityTypeController(CityTypeService service) {
        super(service);
    }
}
