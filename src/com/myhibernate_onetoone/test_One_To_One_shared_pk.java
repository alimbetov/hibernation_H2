package com.myhibernate_onetoone;

import com.myhibernate_onetoone.sharedprimarykey.entitys.Address;
import com.myhibernate_onetoone.sharedprimarykey.entitys.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class test_One_To_One_shared_pk {


    public static void main(String[] args) {



       StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
       try {
           SessionFactory sessionFactory =
                   new MetadataSources(registry).buildMetadata().buildSessionFactory();
           Session session = sessionFactory.openSession();

           session.beginTransaction();

           Address someAddrres = new Address("WSH street ","54321","NY");

           session.persist(someAddrres);



           User someUser = new User(someAddrres.getId(),"Mishel");
           someUser.setShippingAddress(someAddrres);

           session.persist(someUser);




           session.getTransaction().commit();
           session.close();

           //Hibernate: create table Address (id bigint not null, city varchar(255), street varchar(255), zipcode varchar(255), primary key (id))
           //Hibernate: create table USERS (id bigint not null, username varchar(255), primary key (id))
           //Hibernate: create sequence hibernate_sequence start with 1 increment by 1
           //Hibernate: alter table USERS add constraint FKs9aooke5wnqyig2n9r81hh5tn foreign key (id) references Address
           //Hibernate: call next value for hibernate_sequence
           //Hibernate: insert into Address (city, street, zipcode, id) values (?, ?, ?, ?)
           //Hibernate: insert into USERS (username, id) values (?, ?)
       } catch (HibernateException e) {
           e.printStackTrace();
       }

    }



}


