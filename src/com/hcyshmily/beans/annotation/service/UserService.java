package com.hcyshmily.beans.annotation.service;

// 模拟业务层

import com.hcyshmily.beans.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // 这个注解的意思： 在 IOC容器里面去找有没有和这类型兼容额Bean，有，就自动加进来
    private UserRepository userRepository;

    @Autowired
    @Qualifier("userRepositoryImpl") // 指定装配哪个指定的Bean
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add() {
        System.out.println("UserService add()");
        userRepository.save();
    }
}
