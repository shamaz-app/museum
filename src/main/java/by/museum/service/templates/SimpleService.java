package by.museum.service.templates;

import java.util.List;

/**
 * Created by operb_000 on 29.02.2016.
 */
public interface SimpleService<E> {
    E get(Long id);
    List<E> getAll();
    void delete(Long id);
    E save(E entity);
}
