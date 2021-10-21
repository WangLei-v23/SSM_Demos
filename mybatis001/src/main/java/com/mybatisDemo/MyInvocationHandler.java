package com.mybatisDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * mybatis底层实现
 * 功能: 自定义接口, xml中定义sql, 根据xml通过动态代理实现自定义接口, 自动解析结果集
 * 技术: xml解析, 反射
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    //获取动态代理对象
    private Object getInstence(Class cls){
        //反射获取实例化的对象
        return Proxy.newProxyInstance(cls.getClassLoader(),new Class[]{cls},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1 通过dmo4j 读取和解析xml

        //2 获取数据库连接

        //3 执行sql 获取结果集

        //4 根据实体类解析结果集 转换为实例化的对象/集合


        return null;
    }
}
