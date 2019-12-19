package com.myhibernate_onetoone;

import com.myhibernate_onetoone.foregnkey.entitys.Address;
import com.myhibernate_onetoone.foregnkey.entitys.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class test_One_To_OneForegnKey {

    public static void main(String[] args) {


        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            SessionFactory sessionFactory =
                    new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();


            User someUser = new User("Leon");

            Address someAddrres = new Address( "Lenin street", "54673", "Almaty");

            someUser.setShippingAddress(someAddrres);

            session.persist(someUser);


            session.getTransaction().commit();
            session.close();

            //Hibernate: create table Address (id bigint not null, city varchar(255), street varchar(255), zipcode varchar(255), primary key (id))
            //Hibernate: create table USERS (id bigint not null, username varchar(255), shippingAddress_id bigint not null, primary key (id))
            //Hibernate: alter table USERS drop constraint if exists UK_ob48mbnfmufd417fo9swuhfbv
            //Hibernate: alter table USERS add constraint UK_ob48mbnfmufd417fo9swuhfbv unique (shippingAddress_id)
            //Hibernate: create sequence hibernate_sequence start with 1 increment by 1
            //Hibernate: alter table USERS add constraint FK8b81owquby3hwghtf9oyccwpm foreign key (shippingAddress_id) references Address
            //Hibernate: call next value for hibernate_sequence
            //Hibernate: call next value for hibernate_sequence
            //Hibernate: insert into Address (city, street, zipcode, id) values (?, ?, ?, ?)
            //Hibernate: insert into USERS (shippingAddress_id, username, id) values (?, ?, ?)

        } catch (
                HibernateException e) {
            e.printStackTrace();
        }

    }
}
