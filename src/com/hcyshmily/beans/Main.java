package com.hcyshmily.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

//        HelloWorld helloWorld = new HelloWorld();
//        helloWorld.setName("李兴华");
        // 创建对象和设置属性可以交给 Spring 完成

         // 1. 创建 Spring 的IOC 容易对象
        // ApplicationContext 代表 IOC容器, 实际上是个接口
        // ClassPathXmlApplicationContext 是 ApplicationContext 接口的实现类

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. 从IOC 容器中获取 Bean实例
        // 利用 id 定位到 IOC容器中的Bean
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");

        // 利用类型返回 IOC容器中的bean,不过,但要求 IOC容器中必须只能有一个该类型的Bean
//        HelloWorld helloWorld = ctx.getBean(HelloWorld.class); // 用这种方式,则配置2文件里面Bean的对象只有一个
        // 3. 调用 hello方法
        helloWorld.hello();

        Car car = (Car) ctx.getBean("car") ;
        System.out.println(car);
        Car car2 = (Car) ctx.getBean("car2") ;
        System.out.println(car2);

        Person person = (Person) ctx.getBean("person2");
        System.out.println(person);
    }
}
