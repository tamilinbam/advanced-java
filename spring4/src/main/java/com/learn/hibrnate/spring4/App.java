package com.learn.hibrnate.spring4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring4.xml");
    	employee empp= (employee)ctx.getBean("emp");
        System.out.println(empp );
    }
}
