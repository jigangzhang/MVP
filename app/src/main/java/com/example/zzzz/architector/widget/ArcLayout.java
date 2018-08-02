package com.example.zzzz.architector.widget;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.example.zzzz.architector.R;

/**
 * <p>
 * 底部弧形布局
 * </p>
 */

public class ArcLayout extends FrameLayout {
    private static final String KEY_SUPER_STATE="superState";
    private static final String KEY_ARC_HEIGHT="arcHeight";
    private static final String KEY_ARC_COLOR="arcColor";

    private static final int DEFAULT_ARC_HEIGHT = 40;//单位dp
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    private float mArcHeight;
    private int mArcColor;


    public ArcLayout(@NonNull Context context) {
        this(context, null);
    }

    public ArcLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArcLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ArcLayout);
        mArcHeight = a.getDimension(R.styleable.ArcLayout_arcHeight, dpToPx(DEFAULT_ARC_HEIGHT));
        mArcColor = a.getColor(R.styleable.ArcLayout_arcColor, Color.WHITE);
        a.recycle();
        init();
    }

    private void init() {
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setDither(true);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mPaint.setColor(mArcColor);
        mPath.moveTo(0, getHeight());
        mPath.quadTo(getWidth() / 2, getHeight() - mArcHeight, getWidth(), getHeight());
        mPath.close();
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        final Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_SUPER_STATE, super.onSaveInstanceState());
        bundle.putFloat(KEY_ARC_HEIGHT, mArcHeight);
        bundle.putInt(KEY_ARC_COLOR, mArcColor);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            state = bundle.getParcelable(KEY_SUPER_STATE);
            mArcHeight = bundle.getFloat(KEY_ARC_HEIGHT);
            mArcColor = bundle.getInt(KEY_ARC_COLOR);
            requestLayout();
        }
        super.onRestoreInstanceState(state);
    }

    /**
     * 设置Arc高度
     */
    public void setArcHeight(float arcHeight) {
        mArcHeight = arcHeight;
        requestLayout();
    }

    public float getArcHeight() {
        return mArcHeight;
    }

    /**
     * 设置Arc填充颜色
     */
    public void setArcColor(int arcColor) {
        mArcColor = arcColor;
        requestLayout();
    }

    private int dpToPx(int dp) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) ((dp * scale) + 0.5f);
    }
}

