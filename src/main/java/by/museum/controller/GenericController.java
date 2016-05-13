package by.museum.controller;

import by.museum.entities.template.IdEntity;
import by.museum.service.templates.SimpleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.MappedSuperclass;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@MappedSuperclass
public abstract class GenericController<E extends IdEntity, S extends SimpleService<E>> {

    protected S service;

    protected GenericController(S service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    private List<E> get() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private E getById(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    protected void addOrUpdate(@RequestBody E entity) {
        service.save(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id)
    {
        service.delete(id);
    }
}
