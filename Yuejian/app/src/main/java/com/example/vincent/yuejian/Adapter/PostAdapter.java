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
import com.example.vincent.yuejian.Activity.PostDetail;
import com.example.vincent.yuejian.Bean.PostBean;
import com.example.vincent.yuejian.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Vincent on 2017/10/31.
 */

public class PostAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder>{
    private Context mContext;
    protected List mDataList;
    private LayoutInflater mlayoutInflater;
    public PostAdapter(Context mContext, List<PostBean> mDataList){
        this.mContext = mContext;
        this.mDataList = mDataList;
        mlayoutInflater = LayoutInflater.from(mContext);

    }
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mlayoutInflater.from(parent.getContext()).inflate(R.layout.post_list_item, parent, false);
        return new PostAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
        final PostBean entity = (PostBean) mDataList.get(position);
        if (null == entity)
            return;
        PostAdapter.ViewHolder viewHolder = (PostAdapter.ViewHolder) holder;
        viewHolder.post_user_name.setText(entity.getUname());
        viewHolder.post_content.setText(entity.getPtext());
//        Picasso.with(mContext).load("http://115.159.93.244/new18yuejian/Public/upload/"+entity.getActpic()).into(viewHolder.act_pic);
        viewHolder.post_list_item.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(mContext, PostDetail.class);
                Bundle bundle= new Bundle();
                bundle.putString("userid",entity.getUid());
                bundle.putString("username",entity.getUname());
                bundle.putString("postid", entity.getPid());
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
        ImageView post_user_pic;
        TextView post_user_name;
        TextView post_content;
        CardView post_list_item;
        public ViewHolder(View v) {
            super(v);
            post_user_pic = (ImageView) v.findViewById(R.id.post_user_pic);
            post_user_name = (TextView) v.findViewById(R.id.post_user_name);
            post_content = (TextView) v.findViewById(R.id.post_content);
            post_list_item = (CardView) v.findViewById(R.id.post_list_item);
        }
    }
}
