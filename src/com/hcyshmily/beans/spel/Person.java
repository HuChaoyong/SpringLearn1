package com.hcyshmily.beans.spel;

public class Person {
    private String  name;
    private Car car;

    // 引用Address bean 的city 属性
    private  String city;

    // 根据car的 price, 确定 info:
    // car 的 price > 300000  是金领, 否则是白领

    private String info;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", city='" + city + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
