package ru.pamishenko.myBudget.entitys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;


public class WorkingWithUsers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        SessionFactory factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;


            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.print("input name rolle: ");
            String temp = reader.readLine();

            Rolle newRolle = new Rolle(temp);
            session.save(newRolle);
            session.getTransaction().commit();




    }
}
