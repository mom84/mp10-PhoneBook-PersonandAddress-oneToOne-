package at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.persistence.model;
import at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.persistence.repository.AddressRepository;
import at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.persistence.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PersonTest {

    @Autowired
    private PersonRepository personRepository;


    @BeforeEach
    void beforeEach() {
        personRepository.deleteAll();
        personRepository.saveAll(createPersons());
    }

    @Test
    void testNumberOfPerson() {
        List<Person> personList = personRepository.findAll();
        assertEquals(3, personList.size());
    }

    @Test
    void testPersonName(){
        Optional<Person> mohammad = personRepository.findByName("Mohammad");
        assertTrue(mohammad.isPresent());

        assertTrue(personRepository.
                findByName("Mohammad").stream().allMatch(person -> person.getAdress().getStreet().equals("Nungessergasse12")));

    }

    private List<Person> createPersons() {
        Person mohammad = new Person();
        mohammad.setName("Mohammad");
        mohammad.setAdress(new Adress("Nungessergasse12"));

        Person diaa = new Person();
        diaa.setName("diaa");
        diaa.setAdress(new Adress("Schleifmülgasse"));

        Person dahman = new Person();
        dahman.setName("dahman");
        dahman.setAdress(new Adress("wienerNeustadt"));

        return Stream.of(mohammad,diaa,dahman)
                .collect(Collectors.toList());
    }


}