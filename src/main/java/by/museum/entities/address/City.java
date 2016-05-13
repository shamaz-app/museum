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
@Table(name = "CITY")
public class City extends NamedEntity{

    @ManyToOne(targetEntity = Country.class)
    @JoinColumn(name = "ID_COUNTRY", nullable = false)
    private Country country;

    @ManyToOne(targetEntity = CityType.class)
    @JoinColumn(name = "ID_CITY_TYPE", nullable = false)
    private CityType cityType;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CityType getCityType() {
        return cityType;
    }

    public void setCityType(CityType cityType) {
        this.cityType = cityType;
    }
}
