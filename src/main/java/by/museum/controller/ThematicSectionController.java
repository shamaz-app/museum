package by.museum.controller;

import by.museum.entities.ThematicSection;
import by.museum.service.ThematicSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shamaz on 11.05.2016.
 */
@RestController
@RequestMapping("/thematicSection")
public class ThematicSectionController extends GenericController<ThematicSection, ThematicSectionService>{

    @Autowired
    public ThematicSectionController(ThematicSectionService service) {
        super(service);
    }
}
