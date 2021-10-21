package com.Test;

import com.handler.HelloHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws Exception{
        //Spring MVC 通过反射找到请求对应的handler方法
        String path="/index";
        Class<HelloHandler> helloHandlerClass = HelloHandler.class;
        Method[] methods = helloHandlerClass.getDeclaredMethods();
        for (Method method : methods) {
            RequestMapping annotation = method.getAnnotation(RequestMapping.class);
            if (annotation!=null){
                String[] value = annotation.value();
                for (String s : value) {
                    if (s.equals(path)){
                        Object invoke = method.invoke(new HelloHandler(), null);
                        System.out.println(invoke);
                    }
                }
            }
        }
    }
}
