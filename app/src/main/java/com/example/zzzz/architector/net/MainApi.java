package com.example.zzzz.architector.net;

import com.example.zzzz.architector.bean.ImageInfo;
import com.example.zzzz.architector.bean.QueryResult;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/30.
 */

public class MainApi {
    private static MainApi mainApi;
    private MainApiService mApiService;

    private MainApi(MainApiService apiService) {
        mApiService = apiService;
    }

    public static synchronized MainApi getInstance(MainApiService apiService) {
        if (mainApi == null) {
            mainApi = new MainApi(apiService);
        }
        return mainApi;
    }

    public Observable<QueryResult<ArrayList<ImageInfo>>> getBean(){
         return mApiService.getBean();
    }
}
