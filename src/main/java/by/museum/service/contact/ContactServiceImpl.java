package by.museum.service.contact;

import by.museum.entities.contact.Contact;
import by.museum.repositories.contact.ContactRepository;
import by.museum.service.templates.SimpleServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Анастасия on 16.05.2016.
 */
@Service
public class ContactServiceImpl extends SimpleServiceImpl<Contact, ContactRepository> implements ContactService {
}
