package springthymeleaf.domain;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class PersonsRepository {

    private final List<Person> persons = new ArrayList<>();

    @PostConstruct
    void init() {
        //persons.add(new Person("Tom", 99));
    }

    public List<Person> all() {
        return persons;
    }

    public void add(Person person) {
        persons.add(person);
    }

}
