package com.hcyshmily.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// 这个processer是处理所有的bean的
// 通过一些特殊的过滤，处理特殊的bean
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {

        System.out.println("BeanPostProcessorBeforeInitialization: " + o + ", " + s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessorAfterInitialization: " + o + ", " + s);

        // 还可以在这里操作Bean
        Car car = new Car();
        car.setBrand("Ford");
        return car;
    }
}
