package com.hcyshmily.aop.helloworld;

public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {
    @Override
    public int add(int i, int j) {
        System.out.println("The method add begin with[ " + i + "," + j + " ]");
        int res = i + j;
        System.out.println("The method add end with " + res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("The method sub begin with[ " + i + "," + j + " ]");
        int res = i - j;
        System.out.println("The method sub end with " + res);
        return res;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("The method mul begin with[ " + i + "," + j + " ]");
        int res = i * j;
        System.out.println("The method mul end with " + res);
        return res;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("The method add div with[ " + i + "," + j + " ]");
        int res = i / j;
        System.out.println("The method add div with " + res);
        return res;
    }
}
