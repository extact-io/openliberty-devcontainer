package io.extact.openliberty.sample.webapi.resource;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@ApplicationScoped
@Path("persons")
public class PersonResourceImpl implements PersonResource  {

    @Inject
    private PersonService service;

    @Override
    public Person get(long id) {
        return service.get(id);
    }

    @Override
    public Person add(Person person) {
        return service.add(person);
    }

    @Override
    public List<Person> findByName(String name) {
        return service.findByName(name);
    }

    @Override
    public void reset() {
    }
}
