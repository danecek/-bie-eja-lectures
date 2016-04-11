package bi.eja.htmltags;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

@Model
public class PersonsDB {

    private List<Person> persons;

    @PostConstruct
    void init() {
        persons = new ArrayList<>();
        persons.add(new Person("Tom", 10));
        persons.add(new Person("Bob", 12));
    }

    public List<Person> getPersons() {
        return persons;
    }

    /**
     * @param persons the persons to set
     */
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
