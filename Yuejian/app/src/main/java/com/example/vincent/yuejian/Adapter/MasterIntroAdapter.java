package com.example.vincent.yuejian.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vincent.yuejian.Activity.ActSimpActivity;
import com.example.vincent.yuejian.Activity.MasterClassItem;
import com.example.vincent.yuejian.Bean.Actbean;
import com.example.vincent.yuejian.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by Vincent on 2017/10/26.
 */

public class MasterIntroAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder>{
    private Context mContext;
    protected List mDataList;
    private LayoutInflater mlayoutInflater;
    public MasterIntroAdapter(Context mContext, List<Actbean> mDataList){
        this.mContext = mContext;
        this.mDataList = mDataList;
        mlayoutInflater = LayoutInflater.from(mContext);
    }

    public MasterIntroAdapter(Context mContext){
        this.mContext = mContext;
        mlayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mlayoutInflater.from(parent.getContext()).inflate(R.layout.master_class_item_card, parent, false);
        return new MasterIntroAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
        final Actbean entity = (Actbean) mDataList.get(position);
        if (null == entity)
            return;
        MasterIntroAdapter.ViewHolder viewHolder = (MasterIntroAdapter.ViewHolder) holder;
        viewHolder.master_class_intro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(mContext, MasterClassItem.class);
                Bundle bundle= new Bundle();
                bundle.putString("actiid",entity.getActid());
                bundle.putString("actname",entity.getAname());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
//        viewHolder.activity_name.setText(entity.getAname());
//        Picasso.with(mContext).load("http://115.159.93.244/new18yuejian/Public/upload/"+entity.getActpic()).into(viewHolder.act_pic);
//        viewHolder.activity_name.setText("haha");
//        viewHolder.master_intro.setText("Test");
//        Picasso.with(mContext).load("http://115.159.93.244/new18yuejian/Public/upload/"+entity.getActpic()).into(viewHolder.act_pic);
/*        viewHolder.actitem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(mContext, ActSimpActivity.class);
                Bundle bundle= new Bundle();
                bundle.putString("actiid",entity.getActid());
                bundle.putString("actname",entity.getAname());
                intent.putExtras(bundle);
                mContext.startActivity(intent);

            }
        });*/

    }
    @Override
    public int getItemCount() {
        return mDataList.size();
    }
    private class ViewHolder extends XRecyclerView.ViewHolder {
/*        TextView activity_name;
        ImageView act_pic;
        CardView actitem;*/
//        TextView master_intro;
        LinearLayout master_class_intro;
        public ViewHolder(View v) {
            super(v);
/*            activity_name = (TextView) v.findViewById(R.id.activity_name);
            act_pic = (ImageView) v.findViewById(R.id.activity_pic);
            actitem = (CardView) v.findViewById(R.id.act_item_card);*/
//            master_intro = (TextView) v.findViewById(R.id.master_intro);
            master_class_intro = (LinearLayout) v.findViewById(R.id.master_class_intro);

        }
    }
}
