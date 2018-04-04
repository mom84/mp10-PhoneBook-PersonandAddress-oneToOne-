package at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.persistence.repository;

import at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.persistence.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
