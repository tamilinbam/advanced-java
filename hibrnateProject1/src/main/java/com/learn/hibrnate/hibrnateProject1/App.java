package com.learn.hibrnate.hibrnateProject1;
import org.hibernate.SessionFactory;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
       Configuration cfg= new Configuration();
       cfg.configure();
       SessionFactory factory=cfg.buildSessionFactory();
       Session session = factory.openSession();
       Transaction tr = session.beginTransaction();
       
       student st = new student(11,"tamil",99);
       session.save(st);
       tr.commit();
       System.out.println("Student object is created and saved");
       
    }
}
