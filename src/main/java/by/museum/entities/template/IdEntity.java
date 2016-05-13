package by.museum.entities.template;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by operb_000 on 26.02.2016.
 */
@MappedSuperclass
public class IdEntity {
    @Id
    @GeneratedValue(generator = "common")
    @GenericGenerator(name = "common", strategy = "increment")
    @Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = false)
    private Long id;

    public Long getId() {
        return id;
    }
}
