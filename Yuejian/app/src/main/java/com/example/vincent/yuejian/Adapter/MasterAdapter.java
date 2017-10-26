package com.example.vincent.yuejian.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vincent.yuejian.Activity.ActSimpActivity;
import com.example.vincent.yuejian.Activity.MasterActivity;
import com.example.vincent.yuejian.Bean.Actbean;
import com.example.vincent.yuejian.Bean.MasterBean;
import com.example.vincent.yuejian.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/10/5 0005.
 */

public class MasterAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder>{
    private Context mContext;
    protected List mDataList;
    private LayoutInflater mlayoutInflater;
    public MasterAdapter(Context mContext, List<MasterBean> mDataList){
        this.mContext = mContext;
        this.mDataList = mDataList;
        mlayoutInflater = LayoutInflater.from(mContext);

    }
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mlayoutInflater.from(parent.getContext()).inflate(R.layout.masterlist_item, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
        final MasterBean entity = (MasterBean) mDataList.get(position);
        if (null == entity)
            return;
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.master_name.setText(entity.getMname());
        viewHolder.master_intro.setText(entity.getMintro());
        Picasso.with(mContext).load("http://115.159.93.244/new18yuejian/Public/upload/"+entity.getMpic()).into(viewHolder.master_pic);
        viewHolder.masteritem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(mContext, MasterActivity.class);
                Bundle bundle= new Bundle();
                bundle.putString("master_id",entity.getMid());
                bundle.putString("master_name",entity.getMname());
                intent.putExtras(bundle);
                mContext.startActivity(intent);

            }
        });
    }
    @Override
    public int getItemCount() {
        return mDataList.size();
    }
    private class ViewHolder extends XRecyclerView.ViewHolder {
        TextView master_name;
        TextView master_intro;
        ImageView master_pic;
        CardView masteritem;
        public ViewHolder(View v) {
            super(v);
            master_name = (TextView) v.findViewById(R.id.master_name);
            master_intro = (TextView) v.findViewById(R.id.master_intro);
            master_pic = (ImageView) v.findViewById(R.id.master_pic);
            masteritem = (CardView) v.findViewById(R.id.master_item_card);

        }
    }
}