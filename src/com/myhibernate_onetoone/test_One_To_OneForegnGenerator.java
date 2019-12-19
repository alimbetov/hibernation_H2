package com.myhibernate_onetoone;

import com.myhibernate_onetoone.foreigngenerator.entitys.Address;
import com.myhibernate_onetoone.foreigngenerator.entitys.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class test_One_To_OneForegnGenerator {

    public static void main(String[] args) {


        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            SessionFactory sessionFactory =
                    new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();


            User someUser = new User("Richard");

            Address someAddrres = new Address(someUser, "Vyzov street", "54673", "Almaty");

            someUser.setShippingAddress(someAddrres);

            session.persist(someUser);


            session.getTransaction().commit();
            session.close();

            //Hibernate: create table Address (id bigint not null, city varchar(255), street varchar(255), zipcode varchar(255), primary key (id))
            //Hibernate: create table USERS (id bigint not null, username varchar(255), primary key (id))
            //Hibernate: create sequence hibernate_sequence start with 1 increment by 1
            //Hibernate: alter table Address add constraint FKqggwcfiuc0j6e279sl8hipdhm foreign key (id) references USERS
            //Hibernate: call next value for hibernate_sequence
            //Hibernate: insert into USERS (username, id) values (?, ?)
            //Hibernate: insert into Address (city, street, zipcode, id) values (?, ?, ?, ?)


        } catch (
                HibernateException e) {
            e.printStackTrace();
        }

    }
}
