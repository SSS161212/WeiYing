package com.bwie.lithography.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.lithography.R;
import com.bwie.lithography.activity.VideoPlayerActivity;
import com.bwie.lithography.api.Api;
import com.bwie.lithography.bean.FindBean;
import com.bwie.lithography.dagger.DaggerMyComponent;
import com.bwie.lithography.mvp.presenter.FindPresenter;
import com.bwie.lithography.mvp.view.FindView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.yuqirong.cardswipelayout.CardItemTouchHelperCallback;
import me.yuqirong.cardswipelayout.CardLayoutManager;
import me.yuqirong.cardswipelayout.OnSwipeListener;

/**
 * Created by Dell on 2017/12/12.
 */

public class F_Find extends BaseFragment<FindView, FindPresenter> implements FindView, View.OnClickListener {

    @Inject
    FindPresenter presenter;
    @Bind(R.id.headtitle)
    TextView headtitle;
    @Bind(R.id.find_change)
    Button findChange;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private static FindBean findData;

    @Override
    protected void initDagger() {
        DaggerMyComponent.create().inject(this);
}


    @Override
    protected void initView() {
        headtitle.setText("发现");
        findChange.setOnClickListener(this);
        presenter.getVideoList(Api.CATALOGID, 10 + "");
        recyclerView.setItemAnimator(new DefaultItemAnimator());
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
        MyAdapter adapter = new MyAdapter(getActivity(), findBean);
        findData = findBean;
        recyclerView.setAdapter(adapter);
        CardItemTouchHelperCallback cardCallback = new CardItemTouchHelperCallback(recyclerView.getAdapter(),findData.getRet().getList());
        cardCallback.setOnSwipedListener(new OnSwipeListener<FindBean.RetBean.ListBean>() {
            @Override
            public void onSwiping(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {
                MyAdapter.MyViewHolder myHolder = (MyAdapter.MyViewHolder) viewHolder;
                viewHolder.itemView.setAlpha(1 - Math.abs(ratio) * 0.2f);
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, FindBean.RetBean.ListBean listBean, int direction) {
                MyAdapter.MyViewHolder myHolder = (MyAdapter.MyViewHolder) viewHolder;
                viewHolder.itemView.setAlpha(1f);
            }

            @Override
            public void onSwipedClear() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presenter.getVideoList(Api.CATALOGID, (int) (Math.random() * 9) + "");
                    }
                }, 0L);
            }

        });
        final ItemTouchHelper touchHelper = new ItemTouchHelper(cardCallback);
        final CardLayoutManager cardLayoutManager = new CardLayoutManager(recyclerView, touchHelper);
        recyclerView.setLayoutManager(cardLayoutManager);
        touchHelper.attachToRecyclerView(recyclerView);
        adapter.setCardClickListener(new MyAdapter.cardClickListener() {
            @Override
            public void cardClick(int position) {
                Intent intent = new Intent(getActivity(), VideoPlayerActivity.class);
                intent.putExtra("video", (Parcelable) findData.getRet().getList().get(position));
                startActivity(intent);
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.find;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.find_change:
                presenter.getVideoList(Api.CATALOGID, (int) (Math.random() * 9) + "");
                break;
        }
    }


    private static class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private Context context;
        private FindBean findBean;

        public MyAdapter(Context context, FindBean findBean) {
            this.context = context;
            this.findBean = findBean;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_item, parent, false);
            final MyViewHolder myViewHolder = new MyViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cardClickListener.cardClick(myViewHolder.getPosition());
                }
            });
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Glide.with(context).load(findBean.getRet().getList().get(position).getPic()).into(((MyViewHolder) holder).avatarImageView);
            ((MyViewHolder) holder).headTitle.setText(findBean.getRet().getList().get(position).getTitle());
            ((MyViewHolder) holder).headcontent.setText(findBean.getRet().getList().get(position).getDescription());

        }

        @Override
        public int getItemCount() {
            return findData.getRet().getList().size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView headcontent;
            TextView headTitle;
            ImageView avatarImageView;
            ImageView likeImageView;
            ImageView dislikeImageView;

            MyViewHolder(View itemView) {
                super(itemView);
                headTitle = (TextView) itemView.findViewById(R.id.headTitle);
                headcontent = (TextView) itemView.findViewById(R.id.headcontent);
                avatarImageView = (ImageView) itemView.findViewById(R.id.cardview);
                likeImageView = (ImageView) itemView.findViewById(R.id.iv_like);
                dislikeImageView = (ImageView) itemView.findViewById(R.id.iv_dislike);
            }
        }
        private cardClickListener cardClickListener;

        public void setCardClickListener(MyAdapter.cardClickListener cardClickListener) {
            this.cardClickListener = cardClickListener;
        }

        interface cardClickListener{
            void cardClick(int position);
        }
    }
}
