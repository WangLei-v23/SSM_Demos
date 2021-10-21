package com.test;

import com.entity.User;
import com.mySpringXml.MyApplicationContext;

public class testMyApplocationContext {
    public static void main(String[] args) {
        MyApplicationContext myApplicationContext=new MyApplicationContext("spring.xml");
        User user = (User) myApplicationContext.getBean("user1");
        System.out.println(user);
    }
}
