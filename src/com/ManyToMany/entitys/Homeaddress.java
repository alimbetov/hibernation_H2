package com.ManyToMany.entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Homeaddress {
    @Id
    @GeneratedValue  (strategy = GenerationType.AUTO)
    private int id;
    private String street;

    @ManyToMany
    List<Person> person;

    public Homeaddress() {
    }

    public Homeaddress(String street) {
        this.street = street;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    public void add_my_Persons(Person thePerson) {

        if (this.person==null){
            this.person=new ArrayList<Person>();
        }

        this.person.add((Person) thePerson);
    }



}
