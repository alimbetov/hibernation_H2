package com.ManyToMany.entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToMany
    private List<Homeaddress> homeaddress;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, List<Homeaddress> homeaddress) {
        this.name = name;
        this.homeaddress = homeaddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Homeaddress> getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(List<Homeaddress> homeaddress) {
        this.homeaddress = homeaddress;
    }




}
