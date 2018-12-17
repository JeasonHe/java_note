package com.hjl.demo.service.impl;


import com.hjl.demo.service.CustomiseAnnotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2018/12/17 13:59
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ParameterAnnotationImplTest {

    @Autowired
    private CustomiseAnnotation customiseAnnotation;

    @Test
    public void testAnnotation() {
        customiseAnnotation.testAnnotation("test");
    }
}