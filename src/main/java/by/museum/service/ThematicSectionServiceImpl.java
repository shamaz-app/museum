package by.museum.service;

import by.museum.entities.ThematicSection;
import by.museum.repositories.ThematicSectionRepository;
import by.museum.service.templates.NamedServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by shamaz on 11.05.2016.
 */
@Service
public class ThematicSectionServiceImpl extends NamedServiceImpl<ThematicSection, ThematicSectionRepository> implements ThematicSectionService {
}
