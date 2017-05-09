package springthymeleaf.service;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springthymeleaf.domain.Person;
import springthymeleaf.domain.PersonsRepository;

@Service
public class PersonsService {

    @Autowired
    PersonsRepository persons;

    @PostConstruct
    void init() {
        //persons.add(new Person("Tom", 99));
    }

    public List<Person> getPersons() {
        return persons.all();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

}
