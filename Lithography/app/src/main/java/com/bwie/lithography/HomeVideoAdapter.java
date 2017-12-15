package com.bwie.lithography;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.lithography.bean.HomeBean;

/**
 * Created by 燕子 on 2017/12/14.
 */

public class HomeVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int IS_HEADER = 0;
    private static final int IS_NORMAL = 1;

    private Context context;
    private HomeBean bean;
    public HomeVideoAdapter(HomeBean bean, Context context) {
        this.bean=bean;
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType==IS_HEADER){
              view= LayoutInflater.from(context).inflate(R.layout.item_left_menu, parent, false);
            return new ViewHolder1(view);
        }else {
            view= LayoutInflater.from(context).inflate(R.layout.home_item, parent, false);
            return new ViewHolder2(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolder1){
           /* holder = (ViewHolder1) holder;
            for (int i = 0; i < bean.getRet().getList().get(0).getChildList().size(); i++) {
                title = bean.getRet().getList().get(0).getChildList().get(i).getTitle();
            }*/
          //  ((ViewHolder1) holder).home_tv.setText(title);
        }else if (holder instanceof ViewHolder2){
            holder = (ViewHolder2) holder;
            for (int i = 0; i < bean.getRet().getList().get(position).getChildList().size(); i++) {
                ((ViewHolder2) holder).p_im.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(context).load(bean.getRet().getList().get(position).getChildList().get(i).getPic()).into(((ViewHolder2) holder).p_im);
                ((ViewHolder2) holder).w_tv.setText(bean.getRet().getList().get(position).getChildList().get(i).getTitle());
            }

        }
    }
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return IS_HEADER;
        }else {
            return IS_NORMAL;
        }
    }
    @Override
    public int getItemCount() {
        return bean.getRet().getList().size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        private final TextView home_tv;
        public ViewHolder1(View itemView) {
            super(itemView);
            home_tv = (TextView) itemView.findViewById(R.id.home_tv);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder {
        private final TextView w_tv;
        private final ImageView p_im;

        public ViewHolder2(View itemView) {
            super(itemView);
            p_im = itemView.findViewById(R.id.p_im);
            w_tv = itemView.findViewById(R.id.w_tv);
        }
    }

}
