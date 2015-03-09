/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.Collection;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author danecek
 */
@ManagedBean
@ApplicationScoped
public class PersonsDB {

    Collection<Person> persons = new ArrayList<>();

    /**
     * Creates a new instance of ItemsBean
     */
    public PersonsDB() {
        persons.add(new Person("John", 23));
        persons.add(new Person("Emma", 18));
        persons.add(new Person("Bob", 34));
        persons.add(new Person("Alice", 11));
    }

    public Collection<Person> getPersons() {
        return persons;
    }

}
