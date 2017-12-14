package com.bwie.lithography.dagger;

import com.bwie.lithography.fragment.F_Find;

import dagger.Component;

/**
 * Created by Dell on 2017/12/12.
 */
@Component(modules = MyMoudle.class)
public interface MyComponent {
    public void inject(F_Find f_find);
}
