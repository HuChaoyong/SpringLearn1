package com.hcyshmily.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;


/**
 * 自定义 FactoryBean需要实现 Spring提供的这个接口
 */

public class CarFactoryBean implements FactoryBean {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // 返回Bean的对象
    @Override
    public Object getObject() throws Exception {
        return new Car(brand, 500000);
    }

    // 返回Bean的类型
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    // 是否是单实例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
