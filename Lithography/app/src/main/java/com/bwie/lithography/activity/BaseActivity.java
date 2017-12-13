package com.bwie.lithography.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.bwie.lithography.mvp.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * 1:类的用途
 * 2：@author Dell
 * 3：@date 2017/12/5
 */

public abstract class BaseActivity<V,P extends BasePresenter> extends AppCompatActivity{
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        //ButterKnife绑定
        ButterKnife.bind(this);
        //沉浸状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        initDagger();
        //得到p层实例
        presenter = getPresenter();
        if (presenter != null){
            presenter.attachView((V)this);
        }

        initView();
    }

    protected abstract void initDagger();

    protected abstract void initView();

    protected abstract P getPresenter();

    public abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            //清空订阅管理器
            presenter.removeCompositeDisposable();
            //解除p与v的关联
            presenter.detachView();
        }
        ButterKnife.unbind(this);
    }
}
