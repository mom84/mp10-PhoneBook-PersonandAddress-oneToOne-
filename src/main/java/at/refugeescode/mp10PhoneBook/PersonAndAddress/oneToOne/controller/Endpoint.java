package at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.controller;


import at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.persistence.model.Person;
import at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.persistence.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class Endpoint {

    private PersonRepository personRepository;

    public Endpoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @PostMapping
    void addPerson(@RequestBody Person person){
       personRepository.save(person);
    }
}
