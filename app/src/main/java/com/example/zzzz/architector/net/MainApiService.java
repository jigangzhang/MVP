package com.example.zzzz.architector.net;

import com.example.zzzz.architector.bean.ImageInfo;
import com.example.zzzz.architector.bean.QueryResult;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/1/25.
 */

public interface MainApiService {
    @POST("advertisement/semiLogin/c_list.gson")
    Observable<QueryResult<ArrayList<ImageInfo>>> getBean();
}
