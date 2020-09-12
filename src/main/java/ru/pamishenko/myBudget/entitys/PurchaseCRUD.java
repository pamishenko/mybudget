package ru.pamishenko.myBudget.entitys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PurchaseCRUD {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("configs/product/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("=====================================");


            Product product = session.get(Product.class, 1L);
            Saler saler = session.get(Saler.class, 1L);
            User user = session.get(User.class, 1L);
            String check = "check002";
            Integer count = 2;
            long price = 345;

            Purchase  purchaseCreate = new Purchase(user, check, saler, product, count, price);
            System.out.println(purchaseCreate);
            session.save(purchaseCreate);
            session.getTransaction().commit();
            System.out.println(purchaseCreate);


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
