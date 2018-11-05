package com.hcyshmily.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


public class LoggingAspect {

    /**
     * 定义一个声明切面表达式的方法;
     *  一般的,该方法中不需要添入其他的代码
     *
     *  使用 @Pointcut 来声明切入点表达式
     *
     *  后面的其他通知直接使用方法名来引用当前的切入点表达式
     */
    public void declareJoinPointExpression() { }

    /**
     * 如果要达成做成生命周期的的切面, 需要指定是哪个方法,的哪个周期(执行前 | 执行后)
     *
     * 当调用的目标方法和注解声明的方法相匹配的时候, =>  AOP 会自动为方法所在的那个类,生成一个代理对象;
     * 代理对象,得知需要在执行方法前执行这个方法.
     */
    // 声明该方法是一个前置通知

    // 可以在方法名后加参数; JoinPoint 连接点
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method `" + methodName + "` begins with " + args);
    }



    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method `" + methodName + "` end ");

    }

    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method `" + methodName + "` ends  with " + result);

    }

    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception: " + ex);
    }

    public Object aroundMethod(ProceedingJoinPoint pjd) {

        Object result = null;
        String methodName = pjd.getSignature().getName();
        // 执行目标方法
        try {
            // 前置通知
            System.out.println("The method " + methodName + " begins with [around] " + Arrays.asList(pjd.getArgs()));
            result = pjd.proceed();
            // 后置通知
            System.out.println("The method " + methodName + " ends with [around] " + result);
        } catch (Throwable e) {
            // 异常通知
            e.printStackTrace();
            System.out.println("The method occurs exception [around]: " + e);
        }
        // 后置通知
        System.out.println("The method" + methodName +" ends;  [around]");
        return result;
    }

}
