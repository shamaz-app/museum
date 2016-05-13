package by.museum.controller;

import by.museum.entities.OriginSource;
import by.museum.service.OriginSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shamaz on 11.05.2016.
 */
@RestController
@RequestMapping("/originSource")
public class OriginSourceController extends GenericController<OriginSource, OriginSourceService> {

    @Autowired
    public OriginSourceController(OriginSourceService service) {
        super(service);
    }
}
