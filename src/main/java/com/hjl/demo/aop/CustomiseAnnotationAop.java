package com.hjl.demo.aop;

import com.hjl.demo.annotation.MethodAnnotation;
import com.hjl.demo.annotation.ParameterAnnotation;
import java.lang.reflect.Field;
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
    public void methodAnnotation() {
    }

    /**
     * 切入点：注解
     */
    @Pointcut("@annotation(com.hjl.demo.annotation.ParameterAnnotation)")
    public void paramAnnotation() {

    }

    @Around("methodAnnotation()")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //方法签名
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        //是否是MethodAnnotation注解
        if (methodSignature.getMethod().isAnnotationPresent(MethodAnnotation.class)) {
            LocalTime startTime = LocalDateTime.now().toLocalTime();
            //获取注解
            MethodAnnotation methodAnnotation = methodSignature.getMethod()
                    .getAnnotation(MethodAnnotation.class);
            //获取注解传入的值
            log.info(methodAnnotation.value());
            //执行拦截的方法
            proceedingJoinPoint.proceed();
            LocalTime endTime = LocalDateTime.now().toLocalTime();
            log.info("方法执行时间:{}", endTime.getSecond() - startTime.getSecond());
        } else {
            proceedingJoinPoint.proceed();
        }
        return null;
    }

    @Around("paramAnnotation()")
    public Object paramInterceptor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //TODO 待完善
        return null;
    }
}
