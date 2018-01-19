package com.example.zzzz.architector.ui.presenter;

import android.util.Log;

import com.example.zzzz.architector.bean.Bean;
import com.example.zzzz.architector.ui.base.BaseContract;
import com.example.zzzz.architector.ui.base.BasePresenter;
import com.example.zzzz.architector.ui.contract.MainContract;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/19.
 *
 */

public class MainPresenter extends BasePresenter<MainContract.MainView> implements MainContract.MainPrensenter {

    @Override
    public void getData() {
        mView.onLoading();
        Disposable disposable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("rx -- test");
                e.onComplete();
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e("tag", "accept--" + s);
                        mView.loadData(new Bean());
                        mView.onLoadComplete();
                    }
                });
        addSubscribe(disposable);
    }

}
