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

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.example.vincent.yuejian.Activity.MatchSimpActivity;
import com.example.vincent.yuejian.Bean.Matchbean;
import com.example.vincent.yuejian.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MatchAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder>{

    private Context mContext;
    protected List mDataList;
    private LayoutInflater mlayoutInflater;
    public MatchAdapter(Context mContext, List<Matchbean> mDataList){
        this.mContext = mContext;
        this.mDataList = mDataList;
        mlayoutInflater = LayoutInflater.from(mContext);

    }
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mlayoutInflater.from(parent.getContext()).inflate(R.layout.matchlist_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
        final Matchbean entity = (Matchbean) mDataList.get(position);
        if (null == entity)
            return;
        MatchAdapter.ViewHolder viewHolder = (MatchAdapter.ViewHolder) holder;
        viewHolder.match_name.setText(entity.getGname());
        Picasso.with(mContext).load("http://115.159.93.244/new18yuejian/Public/upload/"+entity.getGpic()).into(viewHolder.match_pic);
        viewHolder.matchitem.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                Intent intent= new Intent(mContext, MatchSimpActivity.class);
                Bundle bundle= new Bundle();
                bundle.putString("matchiid",entity.getGid());
                bundle.putString("matchname",entity.getGname());
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
        TextView match_name;
        ImageView match_pic;
        CardView matchitem;
        public ViewHolder(View v) {
            super(v);
            match_name = (TextView) v.findViewById(R.id.match_name);
            match_pic = (ImageView) v.findViewById(R.id.match_pic);
            matchitem = (CardView) v.findViewById(R.id.match_item_card);

        }
    }

}


