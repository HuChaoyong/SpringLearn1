package com.hcyshmily.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 *   日志切面, =>  吧这个类申明为一个切面,
 *
 *   1. 需要把该类放入到 IOC容器中,
 *   2. 再声明为一个切面
 */

@Aspect
@Component
public class LoggingAspect {

    /**
     * 如果要达成做成生命周期的的切面, 需要指定是哪个方法,的哪个周期(执行前 | 执行后)
     *
     * 当调用的目标方法和注解声明的方法相匹配的时候, =>  AOP 会自动为方法所在的那个类,生成一个代理对象;
     * 代理对象,得知需要在执行方法前执行这个方法.
     */
    // 声明该方法是一个前置通知

//    @Before("execution(public int com.hcyshmily.aop.impl.ArithmeticCalculator.add(int, int))") // 这样就只针对 add 方法
//    @Before("execution(public int com.hcyshmily.aop.impl.ArithmeticCalculator.*(int, int))") // 这样就针对所有 (int, int) 参数的方法
//    // 可以在方法名后加参数; JoinPoint 连接点
//    public void beforeMethod(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        List<Object> args = Arrays.asList(joinPoint.getArgs());
//        System.out.println("The method `" + methodName + "` begins with " + args);
//    }


    /**
     * 后置通知, 在目标方法执行后(无论有没有异常), 执行的通知
     * 这里是不能访问到执行结果的
     */
    @After("execution(public int com.hcyshmily.aop.impl.ArithmeticCalculator.*(int, int))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method `" + methodName + "` end ");

    }

    /**
     *  在方法[正常结束]后执行的代码;
     *   返回通知是可以访问到返回值的
     */
    @AfterReturning(value="execution(public int com.hcyshmily.aop.impl.ArithmeticCalculator.*(int, int))",
    returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method `" + methodName + "` ends  with " + result);

    }

    /**
     *  在目标方法发生了异常才会执行.
     *  可以访问到异常对象, 并且,可以指定,出现了特定异常时,再执行通知, 比如, 指定 空指针异常
     *  ex 可以指定成 NullPointer 异常, 如果不是 NullPointer异常,就不会进去
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value="execution(public int com.hcyshmily.aop.impl.ArithmeticCalculator.*(int, int))",
    throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception: " + ex);
    }

    /**
     * 环绕通知需要携带  ProceedingJoinPoint 类型的参数
     * 环绕通知类似于 动态代理的全过程 : ProceedingJoinPoint 类型的参数, 可以决定是否执行目标方法
     * @param pjd
     */
    @Around("execution(public int com.hcyshmily.aop.impl.ArithmeticCalculator.*(int, int))")
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
