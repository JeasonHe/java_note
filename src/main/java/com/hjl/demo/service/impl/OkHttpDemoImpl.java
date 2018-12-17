package com.hjl.demo.service.impl;

import com.hjl.demo.enums.OkHttpClientObject;
import com.hjl.demo.service.OkHttpDemo;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2018/10/25 15:03
 */
@Service
public class OkHttpDemoImpl implements OkHttpDemo {

    /**
     * json传输方式
     */
    private final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    /**
     * 获取okHttpClient对象
     */
    private final OkHttpClient client = OkHttpClientObject.CLIENT
            .getClientInstance();

    private String result;

    /**
     * get形式,同步执行
     */
    @Override
    public String get(String url) throws IOException {
        //创建请求
        Request request = new Request.Builder()
                .header("User-Agent", "*****")
                .addHeader("Accept", "*****")
                .url(url)
                .build();
        //同步执行请求，将响应结果存放到response中
        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful()) {
            //处理response的响应消息
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * post形式
     */
    @Override
    public String post(String url, String message) throws IOException {
        //请求体传输json格式的数据
        RequestBody requestBody = RequestBody.create(JSON, message);
        //创建请求
        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent", "*****")
                .addHeader("Accept", "*****")
                .post(requestBody)
                .build();
        //同步请求
        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 异步发起请求
     */
    @Override
    public void pool(String url) {
        //创建请求
        Request request = new Request.Builder()
                .url(url)
                .build();

        //异步请求
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("请求失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });
    }
}
