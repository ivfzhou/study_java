package cn.ivfzhou.java.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class MyAOP {

    @Pointcut("execution(* cn.ivfzhou.java.spring.aop.*.*(..))")
    public void cut() {
    }

    @Before("cut()")
    public void before() {
        System.out.println("before");
    }

    @After("cut()")
    public void after() {
        System.out.println("after");
    }

    @Around("cut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around begin");
        Object proceed = pjp.proceed();
        System.out.println("around end");
        return proceed;
    }

    @AfterReturning(value = "cut()", returning = "obj")
    public void afterReturning(Object obj) {
        System.out.println("afterReturning：" + obj);
    }

    @AfterThrowing(value = "cut()", throwing = "e")
    public void afterThrowing(Throwable e) {
        System.out.println("afterThrowing：" + e);
    }

}
