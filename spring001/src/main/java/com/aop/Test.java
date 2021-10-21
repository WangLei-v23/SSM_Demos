package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //自实现aop
//        cal cal=new calImpl();
//        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
//        cal bind = (cal)myInvocationHandler.bind(cal);
//        System.out.println(bind.add(3, 1));
//        System.out.println("------------------------------------");
//        System.out.println(bind.sub(3, 1));
//        System.out.println("------------------------------------");
//        System.out.println(bind.mul(3, 2));
//        System.out.println("------------------------------------");
//        System.out.println(bind.div(6, 2));

        //spring动态代理aop
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-ioc.xml");
        cal bean = applicationContext.getBean(cal.class);
        System.out.println(bean.add(2, 4));

    }
}
