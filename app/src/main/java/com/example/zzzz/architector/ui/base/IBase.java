package com.example.zzzz.architector.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public interface IBase {
    /**
     * 界面初始化，对应Activity onCreate生命周期, Fragment onViewCreated生命周期
     */
    void onViewCreate(@Nullable Bundle savedInstanceState);//界面初始化

    void initPresenter();//初始化 presenter
}
