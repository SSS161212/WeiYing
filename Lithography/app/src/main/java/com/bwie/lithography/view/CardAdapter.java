package com.bwie.lithography.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.lithography.R;
import com.bwie.lithography.bean.FindBean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author lenovo
 * 3. @date 2017/11/21 10:20
 */
public class CardAdapter extends BaseAdapter {
    private Context mContext;
    private FindBean mCardList;

    public CardAdapter(Context mContext, FindBean mCardList) {
        Log.i("xxx","CardAdapter");
        this.mContext = mContext;
        this.mCardList = mCardList;
    }

    @Override
    public int getCount() {
        Log.i("xxx","count"+mCardList.getRet().getList().size());
        return mCardList.getRet().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return mCardList.getRet().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            Log.i("xxx","adapter");
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.find_item, parent, false);
            holder = new ViewHolder();
            holder.mCardImageView = (ImageView) convertView.findViewById(R.id.find_pic);
            holder.mCardName = (TextView) convertView.findViewById(R.id.find_title);
            holder.mCardImageNum = (TextView) convertView.findViewById(R.id.find_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext)
                .load(mCardList.getRet().getList().get(position).getPic())
                .into(holder.mCardImageView);
        holder.mCardName.setText(mCardList.getRet().getList().get(position).getTitle());
        holder.mCardImageNum.setText(mCardList.getRet().getList().get(position).getDescription());
        return convertView;
    }

    class ViewHolder {
        TextView mCardName;
        TextView mCardImageNum;
        ImageView mCardImageView;
    }
}
