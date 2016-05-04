package by.museum.service.templates;

import by.museum.entities.template.IdEntity;
import by.museum.repositories.template.SimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by operb_000 on 29.02.2016.
 */
public abstract class SimpleServiceImpl<E extends IdEntity, R extends SimpleRepository<E>>
        implements SimpleService<E> {

    @Autowired
    protected R repository;

    @Override
    public E get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<E> getAll() {
        List<E> entities = new ArrayList<>();
        repository.findAll().forEach(entities::add);
        return entities;
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public E save(E entity) {
        repository.save(entity);
        return null;
    }
}
