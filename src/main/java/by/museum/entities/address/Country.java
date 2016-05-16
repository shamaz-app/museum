package by.museum.entities.address;

import by.museum.entities.template.AbbrevEntity;
import by.museum.entities.template.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by shamaz on 06.05.2016.
 */
@Entity
@Table(name = "COUNTRY")
public class Country extends AbbrevEntity {

    @JsonIgnore
    @OneToMany(targetEntity = City.class)
    @JoinColumn(name = "ID_COUNTRY")
    private Set<City> cities;

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }
}
