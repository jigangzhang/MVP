package com.example.zzzz.architector.ui.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * Created by Administrator on 2018/1/29.
 */

public abstract class BaseFragment<T extends BaseContract.BasePresenter> extends Fragment implements BaseContract.BaseView {
    private static final String TAG = "BaseFragment";
    T mPresenter;
    View mRootView;
    Context mContext;

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null)
                parent.removeView(mRootView);
        } else {
            mRootView = inflater.inflate(getResLayoutId(), container, false);
            mContext = mRootView.getContext();
        }
        return mRootView;
    }

    public abstract int getResLayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachView();
    }

    private void attachView() {
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dettachView();
    }

    private void dettachView() {
        if (mPresenter != null)
            mPresenter.dettachView();
    }

    //懒加载, 每次可见状态变化时都会调用该方法
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (mPresenter != null && isVisibleToUser) {
            lazyLoad();
        }
    }

    public void lazyLoad() {
    }

    @Override
    public void onLoading() {

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
}
