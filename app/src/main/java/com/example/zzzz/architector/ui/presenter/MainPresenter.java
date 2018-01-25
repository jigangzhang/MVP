package com.example.zzzz.architector.ui.presenter;

import android.util.Log;

import com.example.zzzz.architector.bean.ImageInfo;
import com.example.zzzz.architector.bean.QueryResult;
import com.example.zzzz.architector.module.HttpModule;
import com.example.zzzz.architector.ui.base.BasePresenter;
import com.example.zzzz.architector.ui.contract.MainContract;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/19.
 *
 */

public class MainPresenter extends BasePresenter<MainContract.MainView> implements MainContract.MainPrensenter {


    public void getBean() {
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
                        mView.loadData(null);
                        mView.loadString(s);
                        mView.onLoadComplete();
                    }
                });
        addSubscribe(disposable);
    }

    private void getrxData() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("ad");
                e.onComplete();
            }
        }).map(new Function<String, ArrayList>() {
            @Override
            public ArrayList apply(String s) throws Exception {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(s);
                return strings;
            }
        }).subscribe(new Consumer<ArrayList>() {
            @Override
            public void accept(ArrayList arrayList) throws Exception {

            }
        });
    }

    @Override
    public void getData() {
        mView.onLoading();
        HttpModule.getApiInstace()
                .getBean()
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<QueryResult<ArrayList<ImageInfo>>>() {
                    @Override
                    public void accept(QueryResult<ArrayList<ImageInfo>> result) throws Exception {
                        Log.e("tag", "accept--" + result.toString());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<QueryResult<ArrayList<ImageInfo>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addSubscribe(d);
                    }

                    @Override
                    public void onNext(QueryResult<ArrayList<ImageInfo>> result) {
                        mView.loadString(result.getResult().toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onNetError();
                        Log.e("tag", "error--" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        mView.onLoadComplete();
                    }
                });
    }

}
