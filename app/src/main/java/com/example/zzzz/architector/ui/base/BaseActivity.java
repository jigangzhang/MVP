package com.example.zzzz.architector.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Administrator on 2018/1/19.
 * T extends BaseContract.BasePresenter
 * T extends BasePresenter  两者有何区别吗
 */

public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends AppCompatActivity implements IBase, BaseContract.BaseView {
    private static String TAG = "BaseActivity";
    public T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setPresenter();
        attachView();
        initPresenter();
        onViewCreate(savedInstanceState);
    }

    //获取界面布局id
    public abstract int getLayoutId();

    //实例化Presenter
    public abstract void setPresenter();

    @Override
    protected void onStop() {
        super.onStop();
        if (mPresenter != null)
            mPresenter.unSubscribe();
    }

    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    private void dettachView() {
        if (mPresenter != null) {
            mPresenter.dettachView();
        }
    }

    @Override
    public void onLoading() {
        Log.e(TAG, "loading");
    }

    @Override
    public void onLoadComplete() {

    }

    @Override
    public void onLoadFail() {

    }

    @Override
    public void onNetError() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dettachView();
    }
}
