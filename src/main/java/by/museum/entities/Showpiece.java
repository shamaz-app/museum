package by.museum.entities;

import by.museum.entities.template.NamedEntity;

import javax.persistence.*;

/**
 * Created by Анастасия on 05.04.2016.
 */
@Entity
@Table(name = "showpiece")
public class Showpiece extends NamedEntity{

    @Column(name = "NOTE")
    private String note;

    @Column(name = "NUMBER_OF_COPIES")
    private String numberOfCopies;

    @Column(name = "AGE")
    private String age;

    @ManyToOne(targetEntity = OriginSource.class)
    @JoinColumn(name = "ID_SOURCE", nullable = false)
    private OriginSource originSource;

    @ManyToOne(targetEntity = ThematicSection.class)
    @JoinColumn(name = "ID_THEMATIC_SECTION", nullable = false)
    private ThematicSection thematicSection;

    @OneToOne(targetEntity = State.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_STATE")
    private State state;

    @ManyToOne(targetEntity = State.class)
    @JoinColumn(name = "ID_SHOWROOM")
    private Showroom showroom;

    @ManyToOne(targetEntity = MuseumBuild.class)
    @JoinColumn(name = "ID_MUSEUM", nullable = false)
    private MuseumBuild museum;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Transient
    private String image;

    @Transient
    public String getImage() {
        return image;
    }

    @Transient
    public void setImage(String image) {
        this.image = image;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(String numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public OriginSource getOriginSource() {
        return originSource;
    }

    public void setOriginSource(OriginSource originSource) {
        this.originSource = originSource;
    }

    public ThematicSection getThematicSection() {
        return thematicSection;
    }

    public void setThematicSection(ThematicSection thematicSection) {
        this.thematicSection = thematicSection;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public MuseumBuild getMuseum() {
        return museum;
    }

    public void setMuseum(MuseumBuild museum) {
        this.museum = museum;
    }
}
