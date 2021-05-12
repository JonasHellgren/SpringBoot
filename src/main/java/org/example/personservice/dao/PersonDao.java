package org.example.personservice.dao;

import org.example.personservice.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person) {
    // default method implementation follows
    UUID id = UUID.randomUUID();
    return insertPerson(id,person);
    }
    List<Person> selectAllPersons();
    Optional<Person> selectPersonById(UUID id);
    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);
}
