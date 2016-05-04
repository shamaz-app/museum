package by.museum.service.templates;


import by.museum.entities.template.IdEntity;

/**
 * Created by operb_000 on 09.03.2016.
 */
public interface NamedService<E extends IdEntity> extends SimpleService<E> {
    E getByName(String name);
}
