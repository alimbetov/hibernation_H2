package com.oneToMany.foreignKeyAsso;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ForeignKeyAssoAccountEntity")
@Table(name = "ACCOUNT", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")})
public class AccountEntity implements Serializable
{
    private static final long serialVersionUID = -6790693372846798580L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer accountId;

    @Column(name = "ACC_NUMBER", unique = true, nullable = false, length = 100)
    private String accountNumber;

    @ManyToOne
    private EmployeeEntity employee;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}