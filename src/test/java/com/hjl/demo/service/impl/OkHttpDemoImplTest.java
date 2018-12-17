package com.hjl.demo.service.impl;

import com.hjl.demo.service.OkHttpDemo;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2018/10/25 19:49
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OkHttpDemoImplTest {

    @Autowired
    OkHttpDemo okHttpDemo;
    private String url = "http://www.baidu.com";

    @Test
    public void get() {
        try {
            okHttpDemo.get(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void post() {
        try {
            okHttpDemo.post(url, "hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void pool() {
        okHttpDemo.pool(url);
    }
}