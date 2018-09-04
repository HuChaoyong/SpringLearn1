package com.hcyshmily.beans.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-spel.xml");

        Address address = (Address) ctx.getBean("address");

        Car car = (Car) ctx.getBean("car");

        Person person = (Person) ctx.getBean("person");

        System.out.println(address);
        System.out.println(car);
        System.out.println(person);
    }
}
