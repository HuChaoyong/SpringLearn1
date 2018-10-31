package com.hcyshmily.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1) // 这个注解用来指定切面的优先级, 越小,优先级越高
@Component
@Aspect
public class VlidationAspect {

    @Before("execution(public int com.hcyshmily.aop.impl.ArithmeticCalculator.*(..))")
    public void validateArgs(JoinPoint joinPoint) {
        System.out.println("validate: " + Arrays.asList(joinPoint.getArgs()));
    }

}
