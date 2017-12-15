package com.bwie.lithography.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.lithography.R;
import com.bwie.lithography.bean.DetailBean;
import com.bwie.lithography.bean.VideoRes;

/**
 * Created by Dell on 2017/12/15.
 */

public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private VideoRes videoRes;

    public CommentAdapter(Context context, VideoRes videoRes) {
        this.context = context;
        this.videoRes = videoRes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (videoRes.getRet().getList().get(position).getUserPic() == "") {
            ((MyViewHolder) holder).headPic.setImageResource(R.mipmap.photo);
        } else {
            Glide.with(context).load(videoRes.getRet().getList().get(position).getUserPic()).into(((MyViewHolder) holder).headPic);
        }
        ((MyViewHolder) holder).userName.setText(videoRes.getRet().getList().get(position).getPhoneNumber());
        ((MyViewHolder) holder).time.setText(videoRes.getRet().getList().get(position).getTime());
        ((MyViewHolder) holder).like.setText(videoRes.getRet().getList().get(position).getLikeNum() + " | ");
        ((MyViewHolder) holder).comment.setText(videoRes.getRet().getList().get(position).getMsg());
    }

    @Override
    public int getItemCount() {
        return videoRes.getRet().getList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView headPic;
        private TextView userName;
        private TextView like;
        private TextView time;
        private TextView comment;

        public MyViewHolder(View itemView) {
            super(itemView);
            headPic = itemView.findViewById(R.id.user_head);
            userName = itemView.findViewById(R.id.user_name);
            like = itemView.findViewById(R.id.like_num);
            time = itemView.findViewById(R.id.com_time);
            comment = itemView.findViewById(R.id.comment);
        }
    }
}
