package by.museum.entities.address;

import by.museum.entities.template.NamedEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(targetEntity = Street.class)
    @JoinColumn(name = "ID_CITY")
    private Set<Street> streets;

    public Set<Street> getStreets() {
        return streets;
    }

    public void setStreets(Set<Street> streets) {
        this.streets = streets;
    }

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
