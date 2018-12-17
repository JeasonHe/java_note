package com.hjl.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2018/12/17 14:54
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE,
        ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {

    String value() default "";
}
