package by.museum.entities;

import by.museum.entities.template.AbbrevEntity;
import by.museum.entities.template.NamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by shamaz on 06.05.2016.
 */
@Entity
@Table(name = "origin_source")
public class OriginSource extends AbbrevEntity{

    @Column(name = "note")
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
