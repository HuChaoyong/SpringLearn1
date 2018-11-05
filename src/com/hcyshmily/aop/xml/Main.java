package com.hcyshmily.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 1. 创建 Spring的 IOC 容器

        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-impl-context-xml.xml");

        // 2. 从 IOC容器中获取 bean的 实例

        ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);

        // 3. 使用 bean

        int result = arithmeticCalculator.add(3, 6);

        result = arithmeticCalculator.div(9, 3);

        System.out.println("result: " + result);
    }
}
