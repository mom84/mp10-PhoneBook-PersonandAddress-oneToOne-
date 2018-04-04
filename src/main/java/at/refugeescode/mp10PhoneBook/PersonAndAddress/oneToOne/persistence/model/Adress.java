package at.refugeescode.mp10PhoneBook.PersonAndAddress.oneToOne.persistence.model;


import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Adress {

    @Id
    @GeneratedValue
    private Long id;

    private String street;


    public Adress() {
    }

    public Adress(String street) {
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", street='" + street + '\'' +
                '}';
    }
}
