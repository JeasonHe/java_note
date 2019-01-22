package com.hjl.demo.service.impl;

import com.hjl.demo.service.ThreadPoolService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2019/1/21 16:38
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadPoolTest {
    @Autowired
    private ThreadPoolService threadPoolService;

    @Test
    public void testThreadPool(){
        threadPoolService.createThreadPool();
    }

}
