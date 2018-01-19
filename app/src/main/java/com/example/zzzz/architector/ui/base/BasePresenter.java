package com.example.zzzz.architector.ui.base;


import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/1/19.
 */

public abstract class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {
    public T mView;
    Disposable mDisposable;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void dettachView() {
        if (mView != null)
            mView = null;
    }

    @Override
    public void addSubscribe(Disposable disposable) {
        mDisposable = disposable;
    }

    @Override
    public void unSubscribe() {
        if (mDisposable != null && !mDisposable.isDisposed())
            mDisposable.dispose();
    }
}
