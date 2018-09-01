package com.hcyshmily.beans.relation;

import com.hcyshmily.beans.autowire.Address;
import com.hcyshmily.beans.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");

        Address address = (Address) ctx.getBean("address");
        System.out.println(address);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

    }
}
