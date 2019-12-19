package com.myhibernate_onetoone;

import com.myhibernate_onetoone.jointable.entitys.Item;
import com.myhibernate_onetoone.jointable.entitys.Shipment;
import com.myhibernate_onetoone.jointable.entitys.ShipmentState;
import com.myhibernate_onetoone.sharedprimarykey.entitys.Address;
import com.myhibernate_onetoone.sharedprimarykey.entitys.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class test_One_To_One_jointable {


    public static void main(String[] args) {



       StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
       try {
           SessionFactory sessionFactory =
                   new MetadataSources(registry).buildMetadata().buildSessionFactory();
           Session session = sessionFactory.openSession();

           session.beginTransaction();

           Item someItemn = new Item("Alfa Item");

           Shipment someShipment = new Shipment();
           someShipment.setAuction(someItemn);

           session.persist(someShipment);
           Item someItem = new Item("Some Item");
           session.persist(someItem);
           Shipment auctionShipment = new Shipment(someItem);
           session.persist(auctionShipment);

           session.getTransaction().commit();
           session.close();


       } catch (HibernateException e) {
           e.printStackTrace();
       }

    }



}


