package com.hcyshmily.beans.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");

        Car car = (Car)ctx.getBean("car");

        System.out.println(car);

        // 关闭 IOC 容器

        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
