package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Alien a=new Alien(1,"roopesh",10);
        Laptop l2=new Laptop(102,"HP",10);
        Laptop l=new Laptop(101,"dell",2);

        a.setLaptops(Arrays.asList(l,l2));
        l.setAline(a);
        l2.setAline(a);


        Configuration config=new Configuration();
        config.addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
        config.configure();
        SessionFactory sf=config.buildSessionFactory();

        Session session=sf.openSession();

        Transaction ts=session.beginTransaction();

        session.persist(l);
        session.persist(l2);
        session.persist(a);

        ts.commit();

        Alien aa=session.find(Alien.class,a.getId());
        System.out.println(aa);
        session.close();
        sf.close();

    }
}