package com.oneToMany;

import com.oneToMany.joinTable.AccountEntity;
import com.oneToMany.joinTable.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashSet;
import java.util.Set;

public class test_OneToManyJT {


    public static void main(String[] args) {

  //      Hibernate one to many mapping with join table

    System.out.println(".......Hibernate One To Many Mapping Example.......\n");


    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    try {
        SessionFactory sessionFactory =
                new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session sessionObj = sessionFactory.openSession();

        sessionObj.beginTransaction();


        AccountEntity account1 = new AccountEntity();
        account1.setAccountNumber("123-345-65454");

        AccountEntity account2 = new AccountEntity();
        account2.setAccountNumber("123-345-6542222");

        AccountEntity account3 = new AccountEntity();
        account1.setAccountNumber("77777777777777");

        AccountEntity account4= new AccountEntity();
        account2.setAccountNumber("88888888888888");



        //Add new Employee object
        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmail("demo-user@mail.com");
        emp.setFirstName("demo");
        emp.setLastName("user");

        EmployeeEntity emp2 = new EmployeeEntity();
        emp2.setEmail("star-user@mail.com");
        emp2.setFirstName("prod");
        emp2.setLastName("admin");



        Set<AccountEntity> accounts = new HashSet<AccountEntity>();
        accounts.add(account1);
        accounts.add(account2);
        emp.setAccounts(accounts);
        //Save Employee
        sessionObj.save(emp);

        Set<AccountEntity> accounts2 = new HashSet<AccountEntity>();
        accounts2.add(account3);
        accounts2.add(account4);


        emp2.setAccounts(accounts2);
        //Save Employee
        sessionObj.save(emp2);


        // Committing The Transactions To The Database
        sessionObj.getTransaction().commit();

        System.out.println("\n.......Records Saved Successfully To The Database.......");

    } catch(Exception sqlException) {
        sqlException.printStackTrace();
    }
}



}