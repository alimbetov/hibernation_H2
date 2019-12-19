package com.myhibernate_onetoone.foregnkey.entitys;


import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;


    protected String username;

    @OneToOne(
        fetch = FetchType.LAZY,
        optional = false, // NOT NULL
        cascade = CascadeType.PERSIST
    )
    @JoinColumn(unique = true) // Defaults to SHIPPINGADDRESS_ID
    protected Address shippingAddress;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }


}
