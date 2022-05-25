package io.extact.openliberty.sample.webapi.resource;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import io.extact.openliberty.sample.webapi.resource.PersonException.CauseError;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonService {

    private Map<Long, Person> personMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        personMap.put(1L, new Person(1L, "taro", 12));
        personMap.put(2L, new Person(2L, "hanko", 9));
        personMap.put(3L, new Person(3L, "bob", 15));
    }

    public Person get(long id) {
        if (!personMap.containsKey(id)) {
            throw new PersonException(CauseError.NOT_FOUND);
        }
        return personMap.get(id);
    }

    public Person add(Person person) {
        personMap.values().stream()
                .filter(p -> p.getName().equals(person.getName()))
                .findAny()
                .ifPresent(p -> {
                    throw new PersonException(CauseError.DUPLICATE);
                });
        var nextId = personMap.keySet().stream().max(Long::compareTo).get() + 1;
        var newPerson = person.withId(nextId);
        personMap.put(nextId, newPerson);
        return newPerson;
    }

    public List<Person> findByName(String name) {
        return personMap.values().stream()
                .filter(p -> p.getName().startsWith(name))
                .collect(Collectors.toList());
    }

    public void reset() {
        personMap = new ConcurrentHashMap<>();
        this.init();
    }
}
