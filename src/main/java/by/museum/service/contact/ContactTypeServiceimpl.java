package by.museum.service.contact;

import by.museum.entities.contact.ContactType;
import by.museum.repositories.contact.ContactTypeRepository;
import by.museum.service.templates.NamedServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Анастасия on 16.05.2016.
 */
@Service
public class ContactTypeServiceimpl extends NamedServiceImpl<ContactType, ContactTypeRepository> implements ContactTypeService {
}
