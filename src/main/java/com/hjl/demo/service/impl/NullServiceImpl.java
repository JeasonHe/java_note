package com.hjl.demo.service.impl;

import com.hjl.demo.service.NullService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2019/1/22 10:26
 */
@Service
@Slf4j
public class NullServiceImpl implements NullService {

    @Override
    public void nullEquals(String str) {
        String target = "null";

        /**
         * equals左侧不得为null,报空指针
         * 原因：equals()是String类的实例方法，左侧为null则无法调用equals方法。
         */
        boolean equals = str.equals(target);

    }

    @Override
    public void equalsNull(String str) {
        String source = "null";

        /**
         * equals右侧可以为null，不报异常
         */
        boolean equals = source.equals(str);
    }
}
