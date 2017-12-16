package com.bwie.lithography.dagger;

import com.bwie.lithography.activity.XQActivity;
import com.bwie.lithography.fragment.F_Choiceness;
import com.bwie.lithography.fragment.F_Find;
import com.bwie.lithography.fragment.F_Special;

import dagger.Component;

/**
 * Created by Dell on 2017/12/12.
 */
@Component(modules = MyMoudle.class)
public interface MyComponent {
    public void inject(F_Find f_find);
    public void inject(F_Choiceness f_choiceness);
    public void injectxq(XQActivity XQActivity);
    public void injectfl(F_Special f_special);
}
