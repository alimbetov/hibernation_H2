package com.ManyToMany;

import com.ManyToMany.entitys.Category;
import com.ManyToMany.entitys.Homeaddress;
import com.ManyToMany.entitys.Person;
import com.ManyToMany.entitys.Stock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test_MTM2 {


    public static void main(String[] args) {
//Hibernate one to many mapping with foreign key association
            System.out.println(".......Hibernate One To Many Mapping Example.......\n");


    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
        SessionFactory sessionFactory =
                new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session sessionObj = sessionFactory.openSession();

        sessionObj.beginTransaction();

            Homeaddress homeaddress1 = new Homeaddress("Furanov");
            Homeaddress homeaddress2 = new Homeaddress("Nazarbayev");

            List<Homeaddress> mystreets = new ArrayList<Homeaddress>();

            mystreets.add(homeaddress1);
            mystreets.add(homeaddress2);

            Person myperson = new Person("Ruslan", mystreets);




            sessionObj.persist(homeaddress1);
            sessionObj.persist(homeaddress2);

            sessionObj.persist(myperson);

        // Committing The Transactions To The Database
        sessionObj.getTransaction().commit();

        System.out.println("\n.......Records Saved Successfully To The Database.......");

    } catch(Exception sqlException) {
        sqlException.printStackTrace();
    }
}




}
