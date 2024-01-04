package com.learn.hibrnate.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	student stobj= (student)ctx.getBean("st");
    	java stobj1= (java)ctx.getBean("jt");
    	sql stobj2= (sql)ctx.getBean("sqt");
    	python stobj3= (python)ctx.getBean("pt");
        System.out.println( stobj );
        System.out.println( stobj1 );
        System.out.println( stobj2 );
        System.out.println( stobj3 );
    }
}
