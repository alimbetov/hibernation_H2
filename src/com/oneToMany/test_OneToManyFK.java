package com.oneToMany;

import com.oneToMany.foreignKeyAsso.AccountEntity;
import com.oneToMany.foreignKeyAsso.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashSet;
import java.util.Set;

public class test_OneToManyFK {


    public static void main(String[] args) {

//Hibernate one to many mapping with foreign key association
            System.out.println(".......Hibernate One To Many Mapping Example.......\n");


        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            SessionFactory sessionFactory =
                    new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session sessionObj = sessionFactory.openSession();

            sessionObj.beginTransaction();

            AccountEntity account1 = new AccountEntity();
            account1.setAccountNumber("Account detail 1");

            AccountEntity account2 = new AccountEntity();
            account2.setAccountNumber("Account detail 2");





            AccountEntity account3 = new AccountEntity();
            account3.setAccountNumber("Account detail 3");

            AccountEntity account4 = new AccountEntity();
            account4.setAccountNumber("Account detail 4");


            //Add new Employee object
            EmployeeEntity firstEmployee = new EmployeeEntity();
                            firstEmployee.setEmail("demo-user-first@mail.com");
                            firstEmployee.setFirstName("demo-one");
                            firstEmployee.setLastName("user-one");

            EmployeeEntity secondEmployee = new EmployeeEntity();
                            secondEmployee.setEmail("demo-user-second@mail.com");
                            secondEmployee.setFirstName("demo-two");
                            secondEmployee.setLastName("user-two");

            Set<AccountEntity> accountsOfFirstEmployee = new HashSet<AccountEntity>();
            accountsOfFirstEmployee.add(account1);
            accountsOfFirstEmployee.add(account2);

            Set<AccountEntity> accountsOfSecondEmployee = new HashSet<AccountEntity>();
            accountsOfSecondEmployee.add(account3);
            accountsOfSecondEmployee.add(account4);


            firstEmployee.setAccounts(accountsOfFirstEmployee);
            secondEmployee.setAccounts(accountsOfSecondEmployee);



            //Save Employee
            sessionObj.persist(firstEmployee);
            sessionObj.persist(secondEmployee);




                // Committing The Transactions To The Database
                sessionObj.getTransaction().commit();

                System.out.println("\n.......Records Saved Successfully To The Database.......");

            } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        }



}
