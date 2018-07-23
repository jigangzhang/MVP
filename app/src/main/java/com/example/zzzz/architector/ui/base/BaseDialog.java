package com.example.zzzz.architector.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.WindowManager;

import com.example.zzzz.architector.App;
import com.example.zzzz.architector.R;

import java.io.IOException;

import retrofit2.Response;

public abstract class BaseDialog<P extends BaseContract.BasePresenter> extends Dialog implements IBase {
    public P mPresenter;
    private boolean touchOutCancelable = true;
    private int width = WindowManager.LayoutParams.MATCH_PARENT;
    private int height = -1;

    public BaseDialog(@NonNull Context context, boolean touchOutCancelable) {
        super(context, R.style.dialog_common_style);
        this.touchOutCancelable = touchOutCancelable;
    }

    public BaseDialog(Context context, int style) {
        super(context, style);
        this.touchOutCancelable = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        onViewCreate(savedInstanceState);
        setCanceledOnTouchOutside(touchOutCancelable);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = this.width;
        lp.height = this.height > 0 ? height : WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(lp);
//        getWindow().getDecorView().setBackgroundResource(R.color.transparent);
    }

    public Dialog setWidth(int width) {
        this.width = width;
        return this;
    }

    public Dialog setHeight(int height) {
        this.height = height;
        return this;
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mPresenter != null) {
            mPresenter.unSubscribe();//对应的还有 subscribe()
            mPresenter.dettachView();
            mPresenter = null;
        }
//        App.getInstance().getWatcher().watch(this);//内存泄漏检测
    }
}
