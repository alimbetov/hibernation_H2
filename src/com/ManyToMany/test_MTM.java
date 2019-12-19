package com.ManyToMany;

import com.ManyToMany.entitys.Category;
import com.ManyToMany.entitys.Stock;
import com.oneToMany.foreignKeyAsso.AccountEntity;
import com.oneToMany.foreignKeyAsso.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashSet;
import java.util.Set;

public class test_MTM {


    public static void main(String[] args) {
//Hibernate one to many mapping with foreign key association
            System.out.println(".......Hibernate One To Many Mapping Example.......\n");


    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
        SessionFactory sessionFactory =
                new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session sessionObj = sessionFactory.openSession();

        sessionObj.beginTransaction();

            Stock stock = new Stock();
            stock.setStockCode("7052");
            stock.setStockName("PADINI");

            Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
            Category category2 = new Category("INVESTMENT", "INVESTMENT COMPANY");

            Set<Category> categories = new HashSet<Category>();
            categories.add(category1);
            categories.add(category2);

            stock.setCategories(categories);

            sessionObj.save(stock);


        // Committing The Transactions To The Database
        sessionObj.getTransaction().commit();

        System.out.println("\n.......Records Saved Successfully To The Database.......");

    } catch(Exception sqlException) {
        sqlException.printStackTrace();
    }
}




}
