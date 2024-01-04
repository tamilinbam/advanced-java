package com.learn.hibrnate.hibernateproject3;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory .openSession();
        Transaction tr = session.beginTransaction();
        
        student s1 = new student ();
        student s2 = new student ();
    	student s3 = new student ();
    	
    	laptop l1 = new laptop (1, "HP",s2);
    	laptop l2 = new laptop (2, "leveno" ,s1 );
    	laptop l3 = new laptop (3, "Asus",s1);
    	laptop l4 = new laptop (4, "apple",s3);
    	laptop l5 = new laptop (5 , "ACER",s2);
    	laptop l6 = new laptop (6, "Dell",s2);
    	laptop l7 = new laptop (7, "Mi",s3);
    	
    	List<laptop> ll1 = new ArrayList<laptop>();
    	ll1.add(l1);
    	ll1.add(l5);
    	ll1.add(l6);
    	
    	List<laptop> ll2 = new ArrayList<laptop>();
    	ll2.add(l2);
    	ll2.add(l3);
    	
    	List<laptop> ll3 = new ArrayList<laptop>();
    	ll3.add(l4);
    	ll3.add(l7);
    	
    	
    	s1.setS_rollno(1);
    	s1.setS_name("tamil");
    	s1.setLp(ll2);
    	
    	s2.setS_rollno(2);
    	s2.setS_name("veena");
    	s2.setLp(ll1);
    	
    	s3.setS_rollno(3);
    	s3.setS_name("malai");
    	s3.setLp(ll3);
    	
    	session.save(s1);
        session.save(s2);
        session.save(s3);
        
        session.save(l1);
        session.save(l2);
        session.save(l3);
        session.save(l4);
        session.save(l5);
        session.save(l6);
        session.save(l7);
        
        tr.commit();
    	
        System.out.println( "created successfully !!!!  :)  " );
    }
}
