package com.hjl.demo.service.impl;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.hjl.demo.service.ThreadPoolService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2019/1/21 14:57
 */
@Service
public class ThreadPoolServiceImpl implements ThreadPoolService {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private Integer integer = 0;

    @Override
    public void createThreadPool() {

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-thread-%d").build();

        /**
         * 核心线程数：4
         * 最大线程数：10
         * 空闲线程存活时间：0L
         * 时间单位：毫秒
         * 线程池类型：基于链表的阻塞队列
         * 线程工厂：
         * 池满的策略：抛异常
         */
        ExecutorService pool = new ThreadPoolExecutor(1, 3, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(5),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.addAndGet(1));
            });
        }

        pool.shutdown();
    }
}
