package com.learn.hibrnate.spring3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring3.xml");
    	laptop lapa = (laptop)ctx.getBean("lap");
    	System.out.println(lapa);
    	laptop lapa1 =(laptop)ctx.getBean("lap2");
    	System.out.println(lapa1);
    }
}
