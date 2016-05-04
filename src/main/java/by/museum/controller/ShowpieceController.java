package by.museum.controller;

import by.museum.entities.Showpiece;
import by.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Анастасия on 06.04.2016.
 */
@RestController
@RequestMapping("/showpieces")
public class ShowpieceController extends GenericController<Showpiece, ShowpieceService> implements javax.servlet.Filter{

    @Autowired
    public ShowpieceController(ShowpieceService service) {
        super(service);
    }
}
