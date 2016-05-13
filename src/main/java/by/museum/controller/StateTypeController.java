package by.museum.controller;

import by.museum.entities.StateType;
import by.museum.service.StateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shamaz on 11.05.2016.
 */
@RestController
@RequestMapping("/stateType")
public class StateTypeController extends GenericController<StateType, StateTypeService>{

    @Autowired
    public StateTypeController(StateTypeService service) {
        super(service);
    }
}
