package com.example.zzzz.architector.module;

import com.example.zzzz.architector.bean.ImageInfo;
import com.example.zzzz.architector.bean.QueryResult;
import com.example.zzzz.architector.net.MainApi;
import com.example.zzzz.architector.net.MainApiService;
import com.example.zzzz.architector.net.RetrofitConfig;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/25.
 */

public class HttpModule {
    private static MainApi mInstance;

    private HttpModule() {
    }

    //synchronized 用static修饰时为对象锁，相当于 synchronized(xxx.class)??
    public static synchronized MainApi getApiInstace() {
        if (mInstance == null) {
            mInstance = MainApi.getInstance(RetrofitConfig.getInstance().create(MainApiService.class));
        }
        return mInstance;
    }

}
