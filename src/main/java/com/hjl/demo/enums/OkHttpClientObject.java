package com.hjl.demo.enums;

import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

/**
 * Description :   . okHttpClinet的单例
 *
 * @author : hjl
 * @date : Created in 2018/10/25 15:12
 */
public enum OkHttpClientObject {
    CLIENT;

    private OkHttpClient clientInstance;
    private Integer connectTimeout_time = 10;
    private Integer writeTimeout_time = 10;
    private Integer readTimeout_time = 30;

    OkHttpClientObject() {
        ConnectionPool connectionPool = new ConnectionPool(5, 5L, TimeUnit.SECONDS);

        clientInstance = new OkHttpClient.Builder()
                .connectTimeout(connectTimeout_time, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout_time, TimeUnit.SECONDS)
                .readTimeout(readTimeout_time, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .connectionPool(connectionPool)
                .build();
    }

    public OkHttpClient getClientInstance() {
        return clientInstance;
    }
}
