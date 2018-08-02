package com.example.zzzz.architector.ui.activity;

import android.nfc.Tag;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.zzzz.architector.R;
import com.example.zzzz.architector.ui.base.BaseActivity;
import com.example.zzzz.architector.ui.base.BaseContract;
import com.example.zzzz.architector.ui.contract.MainContract;
import com.example.zzzz.architector.ui.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.MainView {
    private static final String TAG = "MainActivity";

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setPresenter() {
        mPresenter = new MainPresenter();
    }

    @Override
    public void loadData(String bean) {

    }

    @Override
    public void loadString(String text) {
        ((TextView)findViewById(R.id.text)).setText(text);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.unSubscribe();
    }

    @Override
    public void onViewCreate(@Nullable Bundle savedInstanceState) {
        mPresenter.getData();
    }

    @Override
    public void initPresenter() {

    }
}
