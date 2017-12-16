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
import com.bwie.lithography.bean.VideoXQ;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * Created by Dell on 2017/12/14.
 */

public class XQVideoAdapter extends XRecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<VideoXQ.RetBean.ListBean> list;

    public XQVideoAdapter(Context context, ArrayList<VideoXQ.RetBean.ListBean> list) {
        this.context= context;
        this.list= list;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_xq, parent, false);
        return new myviewHolder(view);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            holder = (myviewHolder) holder;
            ((myviewHolder) holder).tv_title.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getPic()).into(((myviewHolder) holder).img_video);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
    }



    @Override
    public int getItemCount() {
        return list.size();

    }

    class myviewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_title;
        private final ImageView img_video;

        public myviewHolder(View itemView) {
            super(itemView);
            img_video = (ImageView) itemView.findViewById(R.id.img_video);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            img_video.setScaleType(ImageView.ScaleType.FIT_XY);

        }
    }

}
