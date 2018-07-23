package com.example.zzzz.architector.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/**
 * <p>
 * Glide对图片做圆角处理,当ImageView使用CENTER_CROP属性时,使用此方法时无效果
 * </p>
 */

public class RoundCornerTransform extends BitmapTransformation {
    private int mRadius;

    public RoundCornerTransform(Context context, int radius) {
        super(context);
        this.mRadius = radius;
    }

    public RoundCornerTransform(BitmapPool bitmapPool) {
        super(bitmapPool);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        if (toTransform == null)
            return null;
        Bitmap result = pool.get(toTransform.getWidth(), toTransform.getHeight(), Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(toTransform.getWidth(), toTransform.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(toTransform, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        canvas.drawRoundRect(new RectF(0, 0, toTransform.getWidth(), toTransform.getHeight()), mRadius, mRadius, paint);
        return result;
    }

    @Override
    public String getId() {
        return getClass().getName() + Math.round(mRadius);
    }
}
