package at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.persistence.repository;


import at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.persistence.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Adress,Long> {
}
