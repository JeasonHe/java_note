package com.hjl.demo.service.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2018/10/25 20:14
 */
@Component
public class ThreadPoolTest {

    private Integer corePoolSize = 10;
    private Integer maximumPoolSizeSize = 100;
    private Integer keepAliveTime = 100;
    private BlockingQueue workQueue = new LinkedBlockingQueue(10);

    ThreadPoolExecutor executor = new ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSizeSize,
            keepAliveTime,
            TimeUnit.SECONDS,
            workQueue);
}
