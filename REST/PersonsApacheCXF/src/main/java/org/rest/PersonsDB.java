/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rest;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author danecek
 */
public class PersonsDB {

    public static final PersonsDB inst = new PersonsDB();

    Map<Integer, Person> persons = new HashMap<>();

    private PersonsDB() {
        persons.put(1, new Person(1, "John"));
             persons.put(2, new Person(2, "Tom"));
    }

}
