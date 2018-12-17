package com.hjl.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description : "@Target（ElementType.type）":用于描述类，接口（包含注解类型）或enum "@Retention(RetentionPolicy.RUNTIME)":在运行时有效
 *
 * @author : hejiale
 * @date : Created in 2018/12/17 11:54
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParameterAnnotation {

    String value() default "";
}
