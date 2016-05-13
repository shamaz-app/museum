package by.museum.service;

import by.museum.entities.OriginSource;
import by.museum.repositories.OriginSourceRepository;
import by.museum.service.templates.NamedServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by shamaz on 11.05.2016.
 */
@Service
public class OriginSourceServiceImpl extends NamedServiceImpl<OriginSource, OriginSourceRepository> implements OriginSourceService{
}
