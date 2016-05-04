package by.museum.repositories.template;

import by.museum.entities.template.NamedEntity;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by operb_000 on 09.03.2016.
 */
@NoRepositoryBean
public interface NamedRepository<E extends NamedEntity> extends SimpleRepository<E> {
    E findByName(String name);
}
