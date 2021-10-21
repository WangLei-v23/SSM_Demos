package com.xml;

import com.entity.User;
import com.xml.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        //基于xml方式构建程序
//        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");
//        UserController userController = (UserController)ioc.getBean("UserController");
//        User user = userController.getUser(1);
//        System.out.println(user);

        //基于注解方式构建  注意扫描层 需要包含后续对象创建所在的包
        // (ioc容器中需要包含后续创建对象的地址 可以多包注入(但是没有必要 只注入父包即可(basePackage
//        ApplicationContext ioc=new AnnotationConfigApplicationContext("com.xml");
//        UserController userController = (UserController)ioc.getBean("userController");
//        User user = userController.getUserById(2);
//        System.out.println(user);

        //基于注解的xml解析
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");
        UserController userController = (UserController)ioc.getBean("userController");
        User user = userController.getUserById(1);
        System.out.println(user);

    }
}
