package by.museum.service;

import by.museum.entities.StateType;
import by.museum.repositories.StateTypeRepository;
import by.museum.service.templates.NamedServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by shamaz on 11.05.2016.
 */
@Service
public class StateTypeServiceImpl extends NamedServiceImpl<StateType, StateTypeRepository> implements StateTypeService{
}
