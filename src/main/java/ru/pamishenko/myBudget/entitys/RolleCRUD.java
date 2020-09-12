package ru.pamishenko.myBudget.entitys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;


public class RolleCRUD {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        SessionFactory factory = new Configuration()
                .configure("configs/user/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;


        try {
            /**
             *create
             */
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.print("input name rolle: ");
            String temp = reader.readLine();
            Rolle newRolle = new Rolle(temp);
            session.save(newRolle);
            session.getTransaction().commit();
            System.out.println(newRolle.toString());


            /**
             *read
             */
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Rolle rolleFromDb = session.get(Rolle.class, 1L);
//            System.out.println(rolleFromDb);
//            session.getTransaction().commit();


            /**
             * update
             */
            Long maxId = null;

            session = factory.getCurrentSession();
            session.beginTransaction();
            maxId = session.createQuery("SELECT MAX(s.id) FROM Rolle s", Long.class).getSingleResult();
            Rolle rolleFromUpdate = session.createQuery("SELECT s FROM Rolle s WHERE s.id = :id", Rolle.class)
                    .setParameter("id", maxId)
                    .getSingleResult();
            rolleFromUpdate.setName(maxId + "user");
            session.getTransaction().commit();

            /**
             * delete
             */
//            String rolleFromDelete;
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            rolleFromDelete = session.createQuery("SELECT (s.name) FROM Rolle s WHERE s.name = '57user'", String.class).getSingleResult();
//            session.delete(session.get(Rolle.class, maxId));
//            System.out.println("delete " + rolleFromDelete);
//            session.getTransaction().commit();


        } catch (Exception e){
            e.printStackTrace();
        } finally {
            reader.close();
            factory.close();
            if (session != null) {
                session.close();
            }
        }

    }
}
