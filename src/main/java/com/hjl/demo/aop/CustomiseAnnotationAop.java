package com.hjl.demo.aop;

import com.hjl.demo.annotation.MethodAnnotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2018/12/17 14:17
 */
@Component
@Aspect
@Slf4j
public class CustomiseAnnotationAop {

    /**
     * execution规则： *： 返回值类型任意;  com.hjl.demo.service: 所有的service包 .. ：当前包和包含的子包 *: 所有类 .*：所有方法
     * (..):所有参数
     */
    @Pointcut("execution(* com.hjl.demo.service..*.*(..))")
    public void customiseAnnotation() {
    }

    @Around("customiseAnnotation()")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //方法签名
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        //方法签名
        log.info("getSignature(),{}", methodSignature);

        //是否是注解的呈现
        if (methodSignature.getMethod().isAnnotationPresent(MethodAnnotation.class)) {
            LocalTime startTime = LocalDateTime.now().toLocalTime();
            proceedingJoinPoint.proceed();
            LocalTime endTime = LocalDateTime.now().toLocalTime();
            log.info("方法执行时间:{}", endTime.getSecond() - startTime.getSecond());
        } else {
            log.info("name:{}", proceedingJoinPoint.getTarget().getClass().getName());
        }
        return null;
    }

    /**
     * 获取调用的目标方法
     */
    private Method getMethod(ProceedingJoinPoint pjp) throws NoSuchMethodException {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        return signature.getMethod();
    }

}
