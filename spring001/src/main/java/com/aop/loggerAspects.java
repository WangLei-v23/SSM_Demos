package com.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class loggerAspects {

    @Before("execution(public int com.aop.calImpl.add(..))")
    public void before(JoinPoint joinPoint){
        //获取方法名
        String methordName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();//获取方法参数
        System.out.println(methordName+"方法的参数是："+ Arrays.toString(args));
    }


    @AfterReturning(value = "execution(public int com.aop.calImpl.add(..))",returning = "result")
    public void after(JoinPoint joinPoint,Object result){
        //获取方法名
        String methordName = joinPoint.getSignature().getName();
        System.out.println(methordName+"方法的结果是："+result);

    }
}
