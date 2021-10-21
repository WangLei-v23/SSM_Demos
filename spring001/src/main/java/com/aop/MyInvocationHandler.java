package com.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {
    //委托对象
    private Object object=null;

    //返回代理对象
    public Object bind(Object object){
        this.object=object;
        return Proxy.newProxyInstance(
                MyInvocationHandler.class.getClassLoader(),//类加载器
                object.getClass().getInterfaces(),//拿到委托对象的接口，动态实现
                this//使用当前类的实例完成此操作
                );
    }

    //调用代理对象执行方法时进入invoke
    //操作委托对象，执行业务代码
    //操作代理对象，执行非业务代码
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "方法的入参是：" + Arrays.toString(args));
        Object invoke = method.invoke(this.object, args);
        System.out.println(method.getName()+"方法的结果是："+invoke);
        return invoke;
    }
}
