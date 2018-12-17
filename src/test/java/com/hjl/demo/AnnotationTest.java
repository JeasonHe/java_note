package com.hjl.demo;

import com.hjl.demo.annotation.ParameterAnnotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2018/12/17 13:49
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AnnotationTest {

    @ParameterAnnotation("test")
    private String test;

    @Test
    public void testCustomiseAnnotation() {
        System.out.println(test);
    }
}
