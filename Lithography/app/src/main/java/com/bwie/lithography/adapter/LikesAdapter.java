package com.bwie.lithography.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.lithography.R;
import com.bwie.lithography.bean.DetailBean;

/**
 * Created by Dell on 2017/12/15.
 */

public class LikesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private DetailBean detailBean;

    public LikesAdapter(Context context, DetailBean detailBean) {
        this.context = context;
        this.detailBean = detailBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.likes_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).title.setText(detailBean.getRet().getList().get(0).getChildList().get(position).getTitle());
        Glide.with(context).load(detailBean.getRet().getList().get(0).getChildList().get(position).getPic()).into(((MyViewHolder)holder).pic);
    }

    @Override
    public int getItemCount() {
        return detailBean.getRet().getList().get(0).getChildList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView pic;
        private TextView title;
        public MyViewHolder(View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.video_pic);
            title = itemView.findViewById(R.id.video_title);
        }
    }
}
