package com.example.zzzz.architector.ui.contract;

import com.example.zzzz.architector.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/1/19.
 */

public interface MainContract extends BaseContract.BasePresenter {
    interface MainView extends BaseContract.BaseView{
        void loadData(String bean);
        void loadString(String text);
    }
    interface MainPrensenter extends BaseContract.BasePresenter<MainView>{
        void getData();
    }
}
