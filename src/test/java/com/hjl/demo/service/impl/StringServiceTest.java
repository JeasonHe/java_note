package com.hjl.demo.service.impl;

import com.hjl.demo.service.StringService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description :
 *
 * @author : hejiale
 * @date : Created in 2019/1/22 11:32
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StringServiceTest {

    @Autowired
    private StringService stringService;

    @Test
    public void addressAndValue(){
        stringService.addressAndValue();
    }
}
