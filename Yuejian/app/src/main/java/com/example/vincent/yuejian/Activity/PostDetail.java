package com.example.vincent.yuejian.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vincent.yuejian.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * * Created by Vincent on 2017/11/2.
* 发帖详情页
* 通过postActivity页面传来的帖子id等参数
* 通过Post/postlist获取帖子及评论详情数据并显示
* 未写：需要post service中单独的post对象数据库表信息
* */
public class PostDetail extends AppCompatActivity {
    private XRecyclerView post_reply_list;
    private Context pContext;
    private ImageView svg_back;
    private TextView simp_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.post_detail);
        initView();
        getLastActivityData();
        getPostDetailData();
    }

    public void initView(){
        pContext = this;
        post_reply_list = (XRecyclerView) findViewById(R.id.post_reply_list);
        post_reply_list.setLayoutManager(new LinearLayoutManager(this));

        simp_title = (TextView) findViewById(R.id.simp_title);
        svg_back = (ImageView) findViewById(R.id.svg_back);
        svg_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        simp_title.setText("晒图详情");
    }

    public void getLastActivityData(){
        /**
         * 获取上一activity 即postActivity页面的参数
         **/
    }

    public void getPostDetailData(){
        /*
        * 获取帖子详情数据&评论数据
        * 上半部分为该id下的帖子详情
        * 下半部分为一个XrecycleView
        * 存放依据帖子id获取得到的所有评论详情数据
        * post_detail.xml中的xrecycleViewer
        * PostReplyBean
        * PostReplyAdapter
        * PostReplyService
        * post_reply_list_item.xml
        * */
    }


}
