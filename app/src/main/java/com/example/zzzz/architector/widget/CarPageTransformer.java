package com.example.zzzz.architector.widget;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zzzz.architector.R;
import com.example.zzzz.architector.util.ScreenHelper;

//ViewPager 转换 特殊效果
public class CarPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
       /* ImageView img = page.findViewById(R.id.item_car_img);
        TextView name = page.findViewById(R.id.item_car_name);
        LinearLayout.LayoutParams nameParams = new LinearLayout.LayoutParams(name.getLayoutParams());
        LinearLayout.LayoutParams carParams = new LinearLayout.LayoutParams(img.getLayoutParams());
        int margin = (page.getWidth() - img.getWidth()) / 2;

        if (position >= -1 && position <= 1) {
            if (position < 0) {
                //更改车、车型文字的颜色值
                String hex = Integer.toHexString((int) Math.abs(51 - 121 * position));
                String color = "#" + hex + hex + hex;
                img.setColorFilter(Color.parseColor(color));
                name.setTextColor(Color.parseColor(color));

                //设置车型的位置
                nameParams.setMargins((int) ((0 - position) * margin), ScreenHelper.dp2Px(page.getContext(), 5),
                        nameParams.rightMargin, nameParams.bottomMargin);
                name.setLayoutParams(nameParams);


                //设置车图标的位置
                carParams.setMargins((int) ((0 - position) * margin), ScreenHelper.dp2Px(page.getContext(), 10),
                        carParams.rightMargin, carParams.bottomMargin);
                img.setLayoutParams(carParams);
            } else {
                nameParams.setMargins(nameParams.leftMargin, ScreenHelper.dp2Px(page.getContext(), 5),
                        (int) (position * margin), nameParams.bottomMargin);
                name.setLayoutParams(nameParams);

                carParams.setMargins(carParams.leftMargin, ScreenHelper.dp2Px(page.getContext(), 10),
                        (int) (position * margin), carParams.bottomMargin);
                img.setLayoutParams(carParams);

                String hex = Integer.toHexString((int) Math.abs(121 * position + 51));
                String color = "#" + hex + hex + hex;
                img.setColorFilter(Color.parseColor(color));
                name.setTextColor(Color.parseColor(color));
            }
        } else {
            if (position < -1) {
                //设置车图标的位置
                carParams.setMargins(margin, ScreenHelper.dp2Px(page.getContext(), 10),
                        carParams.rightMargin, carParams.bottomMargin);
                img.setLayoutParams(carParams);
            } else {
                carParams.setMargins(carParams.leftMargin, ScreenHelper.dp2Px(page.getContext(), 10),
                        margin, carParams.bottomMargin);
                img.setLayoutParams(carParams);
            }
        }*/
    }
}
