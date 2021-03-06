package com.hjl.demo.controller;

import com.hjl.demo.service.OkHttp;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2018/10/25 15:30
 */
@RestController
public class OkHttpController {

    @Autowired
    OkHttp okHttp;
    private String url = "http://www.baidu.com";
    private String result;

    @RequestMapping("/get")
    public String get() {
        try {
            result = okHttp.get(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/post")
    public String post() {
        try {
            result = okHttp.post(url, "hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/pool")
    public void pool() {
        okHttp.pool(url);
    }

}
