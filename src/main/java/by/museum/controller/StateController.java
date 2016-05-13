package by.museum.controller;

import by.museum.controller.GenericController;
import by.museum.entities.State;
import by.museum.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shamaz on 11.05.2016.
 */
@RestController
@RequestMapping("/state")
public class StateController extends GenericController<State, StateService>{

    @Autowired
    public StateController(StateService service) {
        super(service);
    }
}
