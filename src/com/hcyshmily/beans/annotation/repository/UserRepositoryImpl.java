package com.hcyshmily.beans.annotation.repository;


import org.springframework.stereotype.Repository;

// 模拟持久化层

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save() {
        System.out.println("UserRepository Save ...");
    }
}
