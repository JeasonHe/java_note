package com.hjl.demo.service.impl;

import com.hjl.demo.service.NullService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2019/1/22 10:33
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class NullServiceTest {
    @Autowired
    private NullService nullService;

    @Test
    public void testNullEquals(){
        nullService.nullEquals(null);
    }

    @Test
    public void testEqualsNull(){
        nullService.equalsNull(null);
    }


}
