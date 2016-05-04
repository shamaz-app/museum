package by.museum.repositories.template;

import by.museum.entities.template.IdEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 02.03.2016
 */
@NoRepositoryBean
public interface SimpleRepository<E extends IdEntity> extends CrudRepository<E, Long> {
}
