package by.museum.service.templates;

import by.museum.entities.template.NamedEntity;
import by.museum.repositories.template.NamedRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by operb_000 on 09.03.2016.
 */
public abstract class NamedServiceImpl<E extends NamedEntity, R extends NamedRepository<E>> extends SimpleServiceImpl<E, R> implements NamedService<E>{

    @Autowired
     protected R repository;

    @Override
    public E getByName(String name) {
        return repository.findByName(name);
    }
}
