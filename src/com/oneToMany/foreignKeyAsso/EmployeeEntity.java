package com.oneToMany.foreignKeyAsso;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "ForeignKeyAssoEntity")
@Table(name = "Employee", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "EMAIL") })

public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer employeeId;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private String firstName;

    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    private String lastName;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="EMPLOYEE_ID")
    private Set<AccountEntity> accounts;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountEntity> accounts) {
        this.accounts = accounts;
    }
}
