package com.example.vincent.yuejian.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vincent.yuejian.R;

/**
 * Created by Vincent on 2017/11/2.
 * 关注-Activity页面
 * 未写：缺关注数据库表 或 其他表中关注 属性详情
 */

public class SubscribeActivity extends AppCompatActivity {
    private Context pContext;
    private ImageView svg_back;
    private TextView simp_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.subscribe);
        initView();
        getLastActivityData();
        getPostDetailData();
    }

    public void initView(){
        pContext = this;
        simp_title = (TextView) findViewById(R.id.simp_title);
        svg_back = (ImageView) findViewById(R.id.svg_back);
        svg_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        simp_title.setText("关注");
    }

    public void getLastActivityData(){
        /**
         * 获取上一activity 页面的参数
         **/
    }

    public void getPostDetailData(){
        /*
        获取关注数据
         */
    }
}
