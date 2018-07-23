package com.example.zzzz.architector.ui.base;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

public abstract class BasePopupWindow extends PopupWindow {
    public Activity mActivity;
    private float mAlpha = 0.8f;

    public BasePopupWindow(Activity activity) {
        this(activity, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    public BasePopupWindow(Activity activity, int width, int height) {
        super(width, height);
        mActivity = activity;
        setContentView(onCreateView());
        setBackgroundDrawable(new BitmapDrawable());// 这样设置才能点击屏幕外dismiss窗口
        setFocusable(true);
        onViewCreate();
    }

    public abstract View onCreateView();

    public abstract void onViewCreate();

    public float getAlpha() {
        return mAlpha;
    }

    public void setAlpha(float mAlpha) {
        this.mAlpha = mAlpha;
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        setWindowAlpha(mActivity.getWindow(), mAlpha);
        super.showAtLocation(parent, gravity, x, y);
    }

    @Override
    public void dismiss() {
        setWindowAlpha(mActivity.getWindow(), 1f);
        super.dismiss();
    }

    private void setWindowAlpha(Window window, float alpha) {
        if (window != null) {
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.alpha = alpha;
            window.setAttributes(lp);
        }
    }
}
