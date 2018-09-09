package com.hcyshmily.beans.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

    // Autowired 注解只标识在这里， 标注后，会被子类继承
    @Autowired
    protected  BaseRepository repository;

    public void add() {
        System.out.println("add...");
        System.out.println(repository);
    }
}
