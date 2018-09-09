package com.hcyshmily.aop.helloworld;

public class Main {
    public static void main(String[] args) {
//        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorLoggingImpl();
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();

        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();

        int res1  =proxy.add(1, 2);
        System.out.println("===>" + res1);
        int res2 = proxy.div(4, 2);
        System.out.println("===>" + res2);
        int res3 = proxy.add(4, 3);
        System.out.println("===>" + res3);
    }
}
