package com.example.zzzz.architector.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @project: ymyc_customer_4.0
 * @author: zhangjigang
 * @date: 2018/6/26 10:03
 * @description:
 */

public class CliFrameLayout extends FrameLayout {
    public CliFrameLayout(@NonNull Context context) {
        super(context);
    }

    public CliFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CliFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        View view = getChildAt(0);
        if (view instanceof CliViewPager)
            return view.dispatchTouchEvent(event);
        else
            return super.onTouchEvent(event);
    }
}
