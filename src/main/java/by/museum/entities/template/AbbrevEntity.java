package by.museum.entities.template;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by shamaz on 06.05.2016.
 */
@MappedSuperclass
public class AbbrevEntity extends NamedEntity{
    @Column(name = "abbrev")
    private String abbrev;

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }
}
