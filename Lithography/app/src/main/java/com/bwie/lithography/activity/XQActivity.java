package com.bwie.lithography.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.widget.TextView;

import com.bwie.lithography.R;
import com.bwie.lithography.adapter.XQVideoAdapter;
import com.bwie.lithography.bean.VideoXQ;
import com.bwie.lithography.dagger.DaggerMyComponent;
import com.bwie.lithography.mvp.FPresenter;
import com.bwie.lithography.mvp.FView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class XQActivity extends BaseActivity<FView , FPresenter> implements FView {

    private String modelurl = "";
    private String title = "";
    @Bind(R.id.headtitle)
    TextView headtitle;
    @Inject
    FPresenter presenter;
    @Bind(R.id.xrecycler)
    XRecyclerView recyclerView;
    int page = 0;
    private XQVideoAdapter adapter;
    private List<VideoXQ.RetBean.ListBean> data;
    public Handler handler = new Handler();


    @Override
    public int getLayout() {
        return R.layout.activity_xq;
    }
    @Override
    protected void initDagger() {
        DaggerMyComponent.create().injectxq(this);
    }


    @Override
    protected void initView() {
        Intent intent = getIntent();
        modelurl= (String) intent.getStringExtra("modeurl");
        title = intent.getStringExtra("title");
        headtitle.setText(title.toString());
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setRefreshProgressStyle(12);
        recyclerView.setLoadingMoreProgressStyle(6);
        presenter.getPageHomeInfo(modelurl,0);

        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page++;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presenter.getPageHomeInfo(modelurl,page);
                        recyclerView.refreshComplete();
                    }
                },2000);

            }

            @Override
            public void onLoadMore() {
                page++;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presenter.getPageHomeInfo(modelurl,page);
                        recyclerView.loadMoreComplete();
                    }
                },2000);

            }
        });
    }

    @Override
    protected FPresenter getPresenter() {
        return presenter;
    }


    @Override
    public void onSuccess(List<VideoXQ.RetBean.ListBean> list) {

        if (page==0){
            data=new ArrayList<VideoXQ.RetBean.ListBean>();
        }
        for (int i=0;i<list.size();i++){
            data.add(list.get(i));
        }
        initData(data);

    }

    public void initData(List<VideoXQ.RetBean.ListBean> data){
        if (adapter==null){
            adapter=new XQVideoAdapter(this, (ArrayList<VideoXQ.RetBean.ListBean>) data);
            recyclerView.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }

    }



}
