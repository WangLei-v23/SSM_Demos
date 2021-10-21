package com.test;

import com.configurations.UserConfig;
import com.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test01 {
    public static void main(String[] args) {
        //1 传统方式创建对象
//        User user = new User();
//        user.setId(1);
//        user.setName("tom");
//        user.setAge(12);
//        System.out.println(user);

        //2 spring 读取xml文件创建对象
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
//        Object user1 = applicationContext.getBean("user1");
//        System.out.println(user1);

        //3 注解方式创建对象
        //3.1 为类添加@Component
        ApplicationContext ioc = new AnnotationConfigApplicationContext("com.entity");
        Object user = ioc.getBean("user");
        System.out.println(user);
        //3.2 为配置类中的方法添加@Bean
//        ApplicationContext ioc =new AnnotationConfigApplicationContext(UserConfig.class);
//        Object user = ioc.getBean("getUser");
//        System.out.println(user);


    }
}
