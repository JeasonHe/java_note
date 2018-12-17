package com.hjl.demo.service;

import java.io.IOException;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2018/10/25 15:32
 */
public interface OkHttpDemo {

    String get(String url) throws IOException;

    String post(String url, String message) throws IOException;

    void pool(String url);

}
