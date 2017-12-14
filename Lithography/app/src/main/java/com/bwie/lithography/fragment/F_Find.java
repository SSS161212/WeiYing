package com.bwie.lithography.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.lithography.R;
import com.bwie.lithography.api.Api;
import com.bwie.lithography.bean.FindBean;
import com.bwie.lithography.dagger.DaggerMyComponent;
import com.bwie.lithography.mvp.presenter.FindPresenter;
import com.bwie.lithography.mvp.view.FindView;
import com.bwie.lithography.view.CardAdapter;
import com.bwie.lithography.view.SwipeFlingAdapterView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dell on 2017/12/12.
 */

public class F_Find extends BaseFragment<FindView, FindPresenter> implements FindView {

    @Inject
    FindPresenter presenter;
    @Bind(R.id.headtitle)
    TextView headtitle;
    @Bind(R.id.cardview)
    SwipeFlingAdapterView cardview;

    private FindBean findData;

    @Override
    protected void initDagger() {
        DaggerMyComponent.create().inject(this);
    }

    @Override
    protected View getLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.find, container, false);
    }

    @Override
    protected void initView() {
        headtitle.setText("发现");
        presenter.getVideoList(Api.CATALOGID, 10 + "");
        cardview.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

            }
            @Override
            public void onLeftCardExit(Object dataObject) {
                makeToast(getActivity(), "不喜欢");
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                makeToast(getActivity(), "喜欢");
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }
            @Override
            public void onScroll(float scrollProgressPercent) {
//                View view = cardview.getSelectedView();
//                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
//                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });


        cardview
                .setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                makeToast(getActivity(), "点击图片");
            }
        });
    }

    @Override
    protected FindPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void getVideoList(FindBean findBean) {
        findData = findBean;
        CardAdapter adapter = new CardAdapter(getActivity(),findBean);
        cardview.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    static void makeToast(Context ctx, String s) {
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }
    public void right() {
        cardview.getTopCardListener().selectRight();
    }

    public void left() {
        cardview.getTopCardListener().selectLeft();
    }
}
