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
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.example.vincent.yuejian.Bean.Actbean;
import com.example.vincent.yuejian.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/10/5 0005.
 */

public class ActAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder>{
    private Context mContext;
    protected List mDataList;
    private LayoutInflater mlayoutInflater;
    public ActAdapter(Context mContext, List<Actbean> mDataList){
        this.mContext = mContext;
        this.mDataList = mDataList;
        mlayoutInflater = LayoutInflater.from(mContext);

    }
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mlayoutInflater.from(parent.getContext()).inflate(R.layout.actlist_item, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
        final Actbean entity = (Actbean) mDataList.get(position);
        if (null == entity)
            return;
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.activity_name.setText(entity.getAname());
        Picasso.with(mContext).load("http://115.159.93.244/new18yuejian/Public/upload/"+entity.getActpic()).into(viewHolder.act_pic);
//        viewHolder.activity_name.setText("haha");
//        Picasso.with(mContext).load("http://115.159.93.244/new18yuejian/Public/upload/"+entity.getActpic()).into(viewHolder.act_pic);
        viewHolder.actitem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(mContext, ActSimpActivity.class);
                Bundle bundle= new Bundle();
                bundle.putString("actiid",entity.getActid());
                bundle.putString("actname",entity.getAname());
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
        TextView activity_name;
        ImageView act_pic;
        CardView actitem;
        public ViewHolder(View v) {
            super(v);
            activity_name = (TextView) v.findViewById(R.id.activity_name);
            act_pic = (ImageView) v.findViewById(R.id.activity_pic);
            actitem = (CardView) v.findViewById(R.id.act_item_card);

        }
    }
}
