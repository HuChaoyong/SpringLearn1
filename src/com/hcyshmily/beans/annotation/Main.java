package com.hcyshmily.beans.annotation;

import com.hcyshmily.beans.annotation.controller.UserController;
import com.hcyshmily.beans.annotation.repository.UserRepository;
import com.hcyshmily.beans.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");

//        TestObject to = (TestObject) ctx.getBean("testObject");
//        System.out.println(to);
//
//        UserController userController = (UserController) ctx.getBean("userController");
//        System.out.println(userController);
//
//        UserService userService = (UserService) ctx.getBean("userService");
//        System.out.println(userService);

        // 这个的 id 是在 类里面指定的
        UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
        System.out.println(userRepository);
    }
}
