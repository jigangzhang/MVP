package com.example.zzzz.architector.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zzzz.architector.R;
import com.example.zzzz.architector.bean.Bean;
import com.example.zzzz.architector.ui.base.BaseActivity;
import com.example.zzzz.architector.ui.base.BaseContract;
import com.example.zzzz.architector.ui.contract.MainContract;
import com.example.zzzz.architector.ui.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getData();
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setPresenter() {
        mPresenter = new MainPresenter();
    }

    @Override
    public void loadData(Bean bean) {

    }
}
