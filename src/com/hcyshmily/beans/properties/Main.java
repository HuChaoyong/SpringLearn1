package com.hcyshmily.beans.properties;

import javax.sql.DataSource;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties.xml");

        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource.getConnection());
//        Car car = (Car) ctx.getBean("car");
//        Car car2 = (Car) ctx.getBean("car");
//        System.out.println(car == car2);

    }
}
