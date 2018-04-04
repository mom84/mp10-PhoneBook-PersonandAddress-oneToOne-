package at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.initialize;

import at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.persistence.model.Adress;
import at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.persistence.model.Person;
import at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.persistence.repository.PersonRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class Starter {

    private PersonRepository personRepository;

    @Bean
    ApplicationRunner applicationRunner(PersonRepository personRepository) {
        return args -> {
            personRepository.deleteAll();
            List<Person> persons = createPersons();

            personRepository.saveAll(persons);

            personRepository.findAll().forEach(System.out::println);
            System.out.println("--------------------------------");

        };
    }

    private List<Person> createPersons() {
       Person mohammad = new Person();
        mohammad.setName("Mohammad");
        mohammad.setAdress(new Adress("Nungessergasse12"));

        Person diaa = new Person();
        diaa.setName("diaa");
        diaa.setAdress(new Adress("Schleifmülgasse"));

        return Stream.of(mohammad,diaa)
                .collect(Collectors.toList());
    }

}
