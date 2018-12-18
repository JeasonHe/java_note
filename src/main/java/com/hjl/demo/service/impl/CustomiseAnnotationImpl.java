package com.hjl.demo.service.impl;

import com.hjl.demo.annotation.MethodAnnotation;
import com.hjl.demo.annotation.ParameterAnnotation;
import com.hjl.demo.service.CustomiseAnnotation;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2018/12/17 13:56
 */
@Service
@Data
public class CustomiseAnnotationImpl implements CustomiseAnnotation {

    @ParameterAnnotation(value = "customiseAnnotation")
    private String param;

    @Override
    @MethodAnnotation(value = "method")
    public void testAnnotation(String name) {
        System.out.println(name + ":" + param);
    }

    @Override
    public void testParamAnnotation() {
        System.out.println(param);
    }


}
