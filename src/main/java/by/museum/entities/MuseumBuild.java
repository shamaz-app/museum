package by.museum.entities;

import by.museum.entities.address.Street;
import by.museum.entities.contact.Contact;
import by.museum.entities.template.IdEntity;
import by.museum.entities.template.NamedEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by shamaz on 06.05.2016.
 */
@Entity
@Table(name = "MUSEUM_BUILD ")
public class MuseumBuild extends NamedEntity {

    @JsonIgnore
    @ManyToOne(targetEntity = Street.class)
    @JoinColumn(name = "ID_STREET")
    private Street street;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "MUSEUM_CONTACT",
            joinColumns = @JoinColumn(name = "ID_MUSEUM"),
            inverseJoinColumns = @JoinColumn(name = "ID_CONTACT"))
    private Set<Contact> contacts;

    @Column(name = "HOUSE_NUMBER", nullable = false)
    private String gouseNumber;

    @Column(name = "COUNT_SHOWPIECE")
    private Integer countShowpiece;

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getGouseNumber() {
        return gouseNumber;
    }

    public void setGouseNumber(String gouseNumber) {
        this.gouseNumber = gouseNumber;
    }

    public Integer getCountShowpiece() {
        return countShowpiece;
    }

    public void setCountShowpiece(Integer countShowpiece) {
        this.countShowpiece = countShowpiece;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
}
