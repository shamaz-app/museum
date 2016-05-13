package by.museum.service;

import by.museum.entities.State;
import by.museum.repositories.StateRepository;
import by.museum.service.templates.SimpleServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by shamaz on 11.05.2016.
 */
@Service
public class StateServiceImpl extends SimpleServiceImpl<State, StateRepository> implements StateService{
}
