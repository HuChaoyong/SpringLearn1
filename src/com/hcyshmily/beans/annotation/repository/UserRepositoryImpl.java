package com.hcyshmily.beans.annotation.repository;


import com.hcyshmily.beans.annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 模拟持久化层

@Repository
//@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
    @Autowired(required = false)
    private TestObject testObject;

    @Override
    public void save() {
        System.out.println("UserRepository Save ...");
        System.out.println(testObject);
    }
}