package com.hys.mybatis.config;

import com.hys.annotation.EsOperator;
import com.hys.annotation.EsOperatorEnum;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * es 拦截器
 */
@Aspect
@Component
public class EsAop {

    @Pointcut("@annotation(com.hys.annotation.EsOperator)")
    public  void annotationPointCut() {
        //切面
    }

    //切面拦截之前
    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("参数："+joinPoint.getArgs());
        System.out.println("被代理对象："+joinPoint.getTarget());
        System.out.println("代理对象："+joinPoint.getThis());
        //连接点的方法签名对象
        Signature signature = joinPoint.getSignature();
        System.out.println("方法名称："+signature.getName());

    }

    @Around("annotationPointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println(proceedingJoinPoint);
        if( proceedingJoinPoint instanceof  MethodInvocationProceedingJoinPoint){
            //参数
            MethodInvocationProceedingJoinPoint p = (MethodInvocationProceedingJoinPoint) proceedingJoinPoint;
            Object[] args = proceedingJoinPoint.getArgs();
            try {
                Object proceed = proceedingJoinPoint.proceed();
                MethodSignature signature = (MethodSignature)p.getSignature();
                EsOperator annotation = signature.getMethod().getAnnotation(EsOperator.class);
                EsOperatorEnum type = annotation.type();
                System.out.println("EsOperator value:"+ type);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

            System.out.println();
        }

        return null;
    }

}
