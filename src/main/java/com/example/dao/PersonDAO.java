package com.example.dao;

import com.example.model.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    // Simulated database or data storage
    private List<Person> personList =  new ArrayList<>();
    
    public List<Person> getAllPersons() {
        return personList;
    }

    // Create operation
    public void addPerson(Person person) {
        // Here, you would typically add the person to your data storage
        // For now, let's just add it to the list
        personList.add(person);
    }

    // Read operation - Get person by ID
    public Person getPersonById(int id) {
        // Search for a person by ID
        for (Person person : personList) {
            if (person.getId() == id) {
                return person;
            }
        }
        // If not found, return null
        return null;
    }

    // Update operation
    public void updatePerson(int id, Person updatedPerson) {
        // Search for the person by ID
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId() == id) {
                // Update the person
                personList.set(i, updatedPerson);
                return;
            }
        }
        // If not found, you may throw an exception or handle it as needed
    }

    // Delete operation
    public void deletePerson(int id) {
        // Search for the person by ID
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId() == id) {
                // Remove the person from the list
                personList.remove(i);
                return;
            }
        }
        // If not found, you may throw an exception or handle it as needed
    }
}
