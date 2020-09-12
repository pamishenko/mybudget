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
        String temp = reader.readLine();

        SessionFactory factory = new Configuration()
                .configure("configs/hibernate.cfg")
                .buildSessionFactory();

        Session session = null;

        while (temp != "end" || temp != ""){
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.print("Введите название роли: ");

            Rolle newRolle = new Rolle(reader.readLine());
            session.save(newRolle);
            session.getTransaction().commit();
        }

    }
}
