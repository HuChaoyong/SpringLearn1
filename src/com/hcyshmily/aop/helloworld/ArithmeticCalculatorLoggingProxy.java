package com.hcyshmily.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {

    // 要代理的对象
    private ArithmeticCalculator target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    // 一般情况下， 不这么做， 因为，这么也显得有些复杂
    // ，让普通的程序员写这个动态代理，要求也有点高

    // 动态代理，实现执行方法的前后，输出日志
    public ArithmeticCalculator getLoggingProxy() {
        ArithmeticCalculator proxy = null;

        // 代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        // 代理对象的类型， 即其中有哪些方法
        Class[] interfaces = new Class[]{ArithmeticCalculator.class};
        // 当调用代理对象其中的方法时，该执行的代码
        InvocationHandler h = new InvocationHandler() {
            /**
             *
             * @param proxy 正在返回的代理对象，一般情况下，在invoke方法中都不使用该对象
             * @param method 正在被调用的方法
             * @param args 调用方法时的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println(proxy.toString()); // 为什么不调用， 因为会递归调用，导致内存溢出
//                System.out.println("invoke ...");
                // 日志
                System.out.println("The method 233331 " + method + ",begin with " + Arrays.asList(args));
                // 执行方法
                Object result =  method.invoke(target, args);
                //日志
                System.out.println("The method " + method + "end with " + result);
                return result;
            }
        };
        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);

        return proxy;
    }
}
