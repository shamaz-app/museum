package by.museum.controller.address;

import by.museum.controller.GenericController;
import by.museum.entities.address.StreetType;
import by.museum.service.address.StreetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Анастасия on 16.05.2016.
 */
@RestController
@RequestMapping("/streetType")
public class StreetTypeController extends GenericController<StreetType, StreetTypeService>{

    @Autowired
    public StreetTypeController(StreetTypeService service) {
        super(service);
    }
}
