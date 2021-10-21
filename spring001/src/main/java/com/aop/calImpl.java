package com.aop;

import org.springframework.stereotype.Component;

@Component
public class calImpl implements cal {
    @Override
    public int add(int num1, int num2) {
//        System.out.println("add方法的入参为："+num1+"、"+num2);
        int result=num1+num2;
//        System.out.println("add输出的结果："+result);
        return result;
    }

    @Override
    public int sub(int num1, int num2) {
//        System.out.println("sub方法的入参为："+num1+"、"+num2);
        int result=num1-num2;
//        System.out.println("sub输出的结果："+result);
        return result;
    }

    @Override
    public int mul(int num1, int num2) {
//        System.out.println("mul方法的入参为："+num1+"、"+num2);
        int result=num1*num2;
//        System.out.println("mul输出的结果："+result);
        return result;
    }

    @Override
    public int div(int num1, int num2) {
//        System.out.println("div方法的入参为："+num1+"、"+num2);
        int result=num1/num2;
//        System.out.println("div输出的结果："+result);
        return result;
    }
}
