package ru.pamishenko.myBudget.entitys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pamishenko.myBudget.model.person.Rolle;
import ru.pamishenko.myBudget.model.person.User;

public class UserCRUD {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("configs/user/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;

        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Rolle rolle = session.get(Rolle.class, 3L);
            System.out.println(rolle);
            for (User u : rolle.getUsers()){
                System.out.println(u);
            }
            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();
            User user = session.get(User.class, 1L);
            System.out.println("======= PAVEL: " + user);
            session.getTransaction().commit();


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
