package by.museum.entities.contact;

import by.museum.entities.template.IdEntity;

import javax.persistence.*;

/**
 * Created by shamaz on 06.05.2016.
 */
@Entity
@Table(name = "CONTACT")
public class Contact extends IdEntity {

    @ManyToOne(targetEntity = ContactType.class)
    @JoinColumn(name = "ID_CONTACT_TYPE", nullable = false)
    private ContactType contactType;

    @Column(name = "CONTACT")
    private String contact;

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
