package org.example.personservice.dao;


import org.example.personservice.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PersonDataAccessServicePostGres implements PersonDao {
//Not implemented, just to show easy to replace fake db
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public int insertPerson(Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPersons() {
        return  List.of(new Person(UUID.randomUUID(),"From Postgres"));
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
