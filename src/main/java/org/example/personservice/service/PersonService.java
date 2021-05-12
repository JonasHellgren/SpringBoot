package org.example.personservice.service;

import org.example.personservice.dao.PersonDao;
import org.example.personservice.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service //can use @Component but service more specific
public class PersonService {

    private final PersonDao personDao;  //reference to data base

    @Autowired  //wires to repository/database object "fakeDao", it has the interface PersonDao
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao=personDao;
    }

    public int insertPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPersons() {
        return personDao.selectAllPersons();
    }

    public Optional<Person> getPersonById(UUID id) {
        System.out.println("service: getPersonById called"+personDao.selectPersonById(id));
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePersonById(id,newPerson);
    }

}
