package com.learn.hibrnate.hibernateproject2;

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
        
        technology p1 = new technology();
        technology p2 = new technology();
        technology p3= new technology();
        technology p4 = new technology();
        
        software b1 = new software ();
        software b2 = new software ();
        software b3 = new software ();
        
        //creating list to assign for software
        List<software> l1 = new ArrayList<software>();
        l1.add(b1);
        l1.add(b2);
        
        List<software> l2 = new ArrayList<software>();
        l2.add(b1);
        l2.add(b2);
        l2.add(b3);
        
        List<software> l3 = new ArrayList<software>();
        l3.add(b1);
        l3.add(b3);
        
        List<software> l4 = new ArrayList<software>();
        l4.add(b2);
        l4.add(b3);
        
        // creating list to assign for technology
        List<technology> pl1 = new ArrayList<technology>();
        pl1.add(p1);
        pl1.add(p2);
        pl1.add(p3);
        
        List<technology> pl2 = new ArrayList<technology>();
        pl2.add(p1);
        pl2.add(p2);
        
        List<technology> pl3 = new ArrayList<technology>();
        pl3.add(p3);
        
        //seting value to tech object
        p1.setP_id(22);
        p1.setName("java");
        p1.setB(l1);
        
        p2.setP_id(23);
        p2.setName("html");
        p2.setB(l2);
        
        p3.setP_id(24);
        p3.setName("css");
        p3.setB(l3);
        
        p4.setP_id(25);
        p4.setName("sql");
        p4.setB(l4);
        
        b1.setB_engine_no(1);
        b1.setBrand("tamil");
        b1.setCost(29);
        b1.setP(pl1);   
        
        b2.setB_engine_no(2);
        b2.setBrand("veene");
        b2.setCost(40);
        b2.setP(pl3);
        
        b3.setB_engine_no(3);
        b3.setBrand("sudhakaran");
        b3.setCost(50);
        b3.setP(pl3);
        
       
        
        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);
        session.save(b1);
        session.save(b2);
        session.save(b3);
        
        tr.commit();
        
    	System.out.println( "object saved" );
    }
}
