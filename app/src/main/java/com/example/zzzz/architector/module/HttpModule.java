package com.example.zzzz.architector.module;

import com.example.zzzz.architector.net.MainApiService;
import com.example.zzzz.architector.net.RetrofitConfig;

/**
 * Created by Administrator on 2018/1/25.
 */

public class HttpModule {
    private static MainApiService apiService;

    private HttpModule() {
    }

    //synchronized 用static修饰时为对象锁，相当于 synchronized(xxx.class)??
    public static synchronized MainApiService getApiInstace() {
        if (apiService == null) {
            apiService = RetrofitConfig.getInstance().create(MainApiService.class);
        }
        return apiService;
    }
}
