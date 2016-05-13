package by.museum.controller;

import by.museum.entities.MuseumBuild;
import by.museum.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shamaz on 06.05.2016.
 */
@RestController
@RequestMapping("/museum")
public class MuseumController extends GenericController<MuseumBuild, MuseumService>{

    @Autowired
    public MuseumController(MuseumService service) {
        super(service);
    }
}
