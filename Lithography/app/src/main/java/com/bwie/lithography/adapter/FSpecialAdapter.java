package com.bwie.lithography.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.lithography.R;
import com.bwie.lithography.activity.XQActivity;
import com.bwie.lithography.bean.Mainpage;

import java.util.List;

/**
 * Created by Dell on 2017/12/14.
 */

public class FSpecialAdapter extends RecyclerView.Adapter<FSpecialAdapter.MyViewHolder>{

    private  Context context;
    private List<Mainpage.RetBean.ListBean> list;
    public FSpecialAdapter(Context context, List<Mainpage.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
        if(list== null){
            Log.e("qq" ,"1");
        }else {
            Log.e("qq","2");
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_found,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        MyViewHolder myViewHolder = holder;

            final String title = list.get(position).getTitle();
            String pic = list.get(position).getChildList().get(0).getPic();
        myViewHolder.tv_title.setText(title);
        Glide.with(context)
                .load(pic)
                .into(myViewHolder.img_video);
        if (!TextUtils.isEmpty(getCatalogId(list.get(position).getMoreURL())) && !TextUtils.isEmpty(pic)&& !TextUtils.isEmpty(title)) {


        }

            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        Intent intent = new Intent(context, XQActivity.class);
                        intent.putExtra("modeurl", getCatalogId(list.get(position).getMoreURL()));
                        intent.putExtra("title", title);
                        context.startActivity(intent);


                }
            });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static  String getCatalogId(String url) {
        String catalogId = "";
        String key = "catalogId=";
        if (!TextUtils.isEmpty(url) && url.contains("="))
            catalogId = url.substring(url.indexOf(key) + key.length(), url.lastIndexOf("&"));
        return catalogId;
    }



    class  MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_title;
        private final ImageView img_video;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            img_video = (ImageView) itemView.findViewById(R.id.img_video);
            img_video.setScaleType(ImageView.ScaleType.FIT_XY);

        }
    };

}
