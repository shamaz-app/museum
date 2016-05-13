package by.museum.entities;

import by.museum.entities.template.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by shamaz on 06.05.2016.
 */
@Entity
@Table(name = "SHOWROOM")
public class Showroom extends IdEntity {

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "SHOWROOM_CONTENT",
            joinColumns = @JoinColumn(name = "ID_SHOWROOM"),
            inverseJoinColumns = @JoinColumn(name = "ID_SHOWPIECE"))
    private Set<Showpiece> showpieces;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "SHOWROOM_THEMATIC_SECTION",
            joinColumns = @JoinColumn(name = "ID_SHOWROOM"),
            inverseJoinColumns = @JoinColumn(name = "ID_THEME_SECTION"))
    private Set<ThematicSection> thematicSections;

    @Column(name = "SHOWROOM_NAME", nullable = false)
    private String showroomName;

    public Set<ThematicSection> getThematicSections() {
        return thematicSections;
    }

    public void setThematicSections(Set<ThematicSection> thematicSections) {
        this.thematicSections = thematicSections;
    }

    public Set<Showpiece> getShowpieces() {
        return showpieces;
    }

    public void setShowpieces(Set<Showpiece> showpieces) {
        this.showpieces = showpieces;
    }

    public String getShowroomName() {
        return showroomName;
    }

    public void setShowroomName(String showroomName) {
        this.showroomName = showroomName;
    }
}
