package com.oneToMany;


import com.oneToMany.test.Stock;
import com.oneToMany.test.StockDailyRecord;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;


public class test_OneToManytest {



    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();



            Stock stock = new Stock();
            stock.setStockCode("7052");
            stock.setStockName("PADINI");
            session.save(stock);

            StockDailyRecord stockDailyRecords = new StockDailyRecord();
            stockDailyRecords.setPriceOpen(new Float("1.2"));
            stockDailyRecords.setPriceClose(new Float("1.1"));
            stockDailyRecords.setPriceChange(new Float("10.0"));
            stockDailyRecords.setVolume(3000000L);
            stockDailyRecords.setDate(new Date());
            stockDailyRecords.setStock(stock);


            StockDailyRecord stockDailyRecords2 = new StockDailyRecord();
            stockDailyRecords2.setPriceOpen(new Float("1.5"));
            stockDailyRecords2.setPriceClose(new Float("1.4"));
            stockDailyRecords2.setPriceChange(new Float("8.0"));
            stockDailyRecords2.setVolume(4000000L);
            stockDailyRecords2.setDate(new Date());
            stockDailyRecords2.setStock(stock);


            stock.getStockDailyRecords().add(stockDailyRecords);

            session.save(stockDailyRecords);


            session.getTransaction().commit();

            session.close();


        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }




}
