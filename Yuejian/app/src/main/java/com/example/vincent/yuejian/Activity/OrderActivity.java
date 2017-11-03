package com.example.vincent.yuejian.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.vincent.yuejian.R;

/**
 * Created by Vincent on 2017/11/3.
 * 活动订单页面 缺订单数据库信息 未写
 */

public class OrderActivity extends AppCompatActivity{
    private TextView simp_title;
    private ImageView svg_back;
    private TextView order_all_btn, order_inact_btn, order_done_btn;
    private ImageView order_all_line, order_inact_line, order_done_line;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.order);
        initView();
        getAllOrderData();
    }
    public void initView(){
        simp_title = (TextView) findViewById(R.id.simp_title);
        svg_back = (ImageView) findViewById(R.id.svg_back);
        order_all_btn = (TextView) findViewById(R.id.order_all_btn);
        order_inact_btn = (TextView) findViewById(R.id.order_inact_btn);
        order_done_btn = (TextView) findViewById(R.id.order_done_btn);
        order_all_line = (ImageView) findViewById(R.id.order_all_line);
        order_inact_line = (ImageView) findViewById(R.id.order_inact_line);
        order_done_line = (ImageView) findViewById(R.id.order_done_line);
        simp_title.setText("活动");
        svg_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        order_all_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                resetTextColor();
                resetLineColor();
                order_all_btn.setTextColor(0XFF72BD9C);
                order_all_line.setImageResource(R.drawable.line_checked);
                getAllOrderData();
            }
        });
        order_inact_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                resetTextColor();
                resetLineColor();
                order_inact_btn.setTextColor(0XFF72BD9C);
                order_inact_line.setImageResource(R.drawable.line_checked);
                getInactOrderData();
            }
        });
        order_done_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                resetTextColor();
                resetLineColor();
                order_done_btn.setTextColor(0XFF72BD9C);
                order_done_line.setImageResource(R.drawable.line_checked);
                getDoneOrderData();
            }
        });
    }
    // 获取并显示所有订单数据
    public void getAllOrderData(){

    }
    // 获取待参与订单数据并显示
    public void getInactOrderData(){

    }
    // 获取已完成订单数据并显示
    public void getDoneOrderData(){

    }
    // 初始化标签页文本状态
    private void resetTextColor() {
        order_all_btn.setTextColor(0XFFACACAB);
        order_inact_btn.setTextColor(0XFFACACAB);
        order_done_btn.setTextColor(0XFFACACAB);
    }
    // 初始化标签页line状态
    private void resetLineColor(){
        order_all_line.setImageResource(R.drawable.line_unchecked);
        order_inact_line.setImageResource(R.drawable.line_unchecked);
        order_done_line.setImageResource(R.drawable.line_unchecked);
    }
}
