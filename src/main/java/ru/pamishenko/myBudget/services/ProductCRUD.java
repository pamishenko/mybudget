package ru.pamishenko.myBudget.entitys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductCRUD {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("configs/product/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            factory.close();
            if (session != null){
                session.close();
            }
        }

    }
}
