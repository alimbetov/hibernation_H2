package com.myhibernate_onetomany.variant01.entitys;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class test_one_to_money {



    public static void main(String[] args) {



        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            SessionFactory sessionFactory =
                    new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Student studentObj = new Student("john", "Goodboy",  "javageek@javacodegeeks.com", "0123456789");
            session.save(studentObj);

            MarksDetails marksObj1 = new MarksDetails("English", "100", "90",  "Pass");
            marksObj1.setStudent(studentObj);
            session.save(marksObj1);

            MarksDetails marksObj2 = new MarksDetails("Maths", "100", "99",  "Pass");
            marksObj2.setStudent(studentObj);
            session.save(marksObj2);

            MarksDetails marksObj3 = new MarksDetails("Science", "100", "94",  "Pass");
            marksObj3.setStudent(studentObj);
            session.save(marksObj3);

            session.getTransaction().commit();
            session.close();


        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

}
