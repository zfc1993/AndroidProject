package com.example.vincent.yuejian.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vincent.yuejian.R;

public class ApplyActivity extends AppCompatActivity {
    private ImageView appBack;
    private TextView simp_title;
    private String actid = null, actname = null;
    private TextView activity_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        initView();
        getLastActivityData();
        getApplyData();
    }
    public void initView(){
        appBack = (ImageView)findViewById(R.id.svg_back);
        simp_title = (TextView)findViewById(R.id.simp_title);
        activity_name = (TextView)findViewById(R.id.activity_name_apply);
        simp_title.setText("活动报名");
        appBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
    public void getLastActivityData(){
        Bundle bundle = this.getIntent().getExtras();
        actid = bundle.getString("actiid");
        actname = bundle.getString("actname");
        activity_name.setText(actname);
    }
    public void getApplyData(){
        /*
        * 依据上一activity传来的actid参数
        * 获取活动数据
        * */
    }
}
