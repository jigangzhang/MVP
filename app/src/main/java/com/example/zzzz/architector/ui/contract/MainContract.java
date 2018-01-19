package com.example.zzzz.architector.ui.contract;

import com.example.zzzz.architector.bean.Bean;
import com.example.zzzz.architector.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/1/19.
 */

public interface MainContract extends BaseContract.BasePresenter {
    interface MainView extends BaseContract.BaseView{
        void loadData(Bean bean);
    }
    interface MainPrensenter extends BaseContract.BasePresenter<MainView>{
        void getData();
    }
}
