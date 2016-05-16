package by.museum.controller.contact;

import by.museum.controller.GenericController;
import by.museum.entities.contact.ContactType;
import by.museum.service.contact.ContactTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Анастасия on 16.05.2016.
 */
@RestController
@RequestMapping("/contactType")
public class ContactTypeController extends GenericController<ContactType, ContactTypeService> {

    @Autowired
    public ContactTypeController(ContactTypeService service) {
        super(service);
    }
}
