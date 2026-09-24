package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Hibernate {
    public static void main(String[] args) throws  Exception{
        Student std=new Student(234,"new name",16);

        Configuration config= new Configuration();
        config.addAnnotatedClass(Student.class);
        config.configure();

        SessionFactory sf=config.buildSessionFactory();
        Session session=sf.openSession();

//        ------------ creating data -------------
        Transaction ts=session.beginTransaction();
        session.persist(std);
        ts.commit();

//        without Transaction we will encounter no error but the changes won't reflect in DB
//       ----------------  updating data ------------
//       ------  merge -- updates if there ortherwise creates a new rec
//        Student std=new Student(234,"new name",100);
//        Transaction ts= session.beginTransaction();
//        session.merge(std);
//        ts.commit();

//       ---------------- deleting data -------------
//        Transaction ts= session.beginTransaction();
//        pass object or PK
//        session.remove(std);
//        Student stdRec=session.find(Student.class,234);
//        session.remove(stdRec);
//        ts.commit();

//       ----------------- Querying data - transction is not required
        Student s2= session.find(Student.class,234);
        System.out.println(s2);


        session.close();
        sf.close();
    }
}
