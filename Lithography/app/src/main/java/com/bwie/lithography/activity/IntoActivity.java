package com.bwie.lithography.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.widget.ImageView;

import com.bwie.lithography.R;
import com.bwie.lithography.mvp.presenter.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class IntoActivity extends BaseActivity {

    @Bind(R.id.welcome)
    ImageView welcome;
    private List<Integer> images;

    @Override
    protected void initDagger() {
    }

    @Override
    protected void initView() {
        addImages();
        int random=(int)(Math.random()*6);
        welcome.setImageResource(images.get(random));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
                1.2f, 1.2f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
                1.2f, 1.2f);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(welcome, pvhY, pvhZ);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent intent = new Intent(IntoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        animator.setDuration(2000);
        animator.start();
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_into;
    }

    public void addImages() {
        images = new ArrayList<>();
        images.add(R.mipmap.a);
        images.add(R.mipmap.b);
        images.add(R.mipmap.c);
        images.add(R.mipmap.d);
        images.add(R.mipmap.e);
        images.add(R.mipmap.f);
    }
}
