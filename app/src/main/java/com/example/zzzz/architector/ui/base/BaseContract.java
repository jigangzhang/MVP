package com.example.zzzz.architector.ui.base;

import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/1/19.
 *
 */

public interface BaseContract {
    interface BaseView {
        //一下几个方法可以封装到Retrofit的网络请求CallAdapterFactory中
        void onLoading();
        void onLoadComplete();
        void onLoadFail();
        void onNetError();
    }

    interface BasePresenter<T extends BaseView> {
        void attachView(T view);//在 Presenter 中对 View 进行管理， 绑定 销毁等
        void dettachView();
        void addSubscribe(Disposable disposable);
        //取消数据加载请求
        void unSubscribe();
    }

    interface BaseModel {
    }
}
