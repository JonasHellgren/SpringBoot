package org.example.personservice.api;


import org.example.personservice.model.Person;
import org.example.personservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


/**
 * Post example:  http://localhost:8080/api/v1/person
 * {  "id": "0a60b89c-494e-11ed-b878-0242ac120002", "name": "Kalle" }
 */

@RequestMapping("api/v1/person")    //client url to respond to
@RestController  //express this is an object that defines endpoints clients can consume
public class PersonController {
    //------ Variables
    @Autowired //wires to personService object, it has the interface PersonDao
    private final PersonService personService;  //reference to service
    //------Constructor
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    //------ Methods
    @PostMapping  //handles post requests from client
    //@Valid, triggers validations on person, @RequestBody put json body into object
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        System.out.println("addPerson called, added:"+person.getName());
        personService.insertPerson(person);
    }
    @GetMapping  //handles get requests from client
    public List<Person> getAllPerson() {
        System.out.println("getAllPerson called");
        return personService.getAllPersons();
    }
    @GetMapping(path = "{id}")  //handles get requests from client, with specific id included in request
    public Person getPersonById(@PathVariable("id") UUID id) {  //take id from request and turn into UUID id
        System.out.println("getPersonById called, found:"+personService.getPersonById(id)
                .orElse(null).getName());
        return personService.getPersonById(id)
                .orElse(null);  //cen be improved by e.g. throw
    }
    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate) {
        personService.updatePerson(id,personToUpdate);
    }
}
