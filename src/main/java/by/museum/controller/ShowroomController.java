package by.museum.controller;

import by.museum.entities.Showroom;
import by.museum.service.ShowroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by shamaz on 11.05.2016.
 */
@RestController
@RequestMapping("/showroom")
public class ShowroomController extends GenericController<Showroom, ShowroomService>{

    @Autowired
    public ShowroomController(ShowroomService service) {
        super(service);
    }

    @RequestMapping(value = "/museumId/{museumId}", method = RequestMethod.GET)
    public List<Showroom> getCityById(@PathVariable("museumId") Long museumId) {
        return service.getShowroomsByMuseumId(museumId);
    }
}
