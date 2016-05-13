package by.museum.entities.address;

import by.museum.entities.template.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by shamaz on 06.05.2016.
 */
@Entity
@Table(name = "STREET")
public class Street extends NamedEntity {

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "ID_CITY", nullable = false)
    private City city;

    @ManyToOne(targetEntity = StreetType.class)
    @JoinColumn(name = "ID_STREET_TYPE", nullable = false)
    private StreetType streetType;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public StreetType getStreetType() {
        return streetType;
    }

    public void setStreetType(StreetType streetType) {
        this.streetType = streetType;
    }
}
