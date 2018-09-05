package com.hcyshmily.beans.annotation.service;

// 模拟业务层

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void add() {
        System.out.println("UserService add()");
    }
}
