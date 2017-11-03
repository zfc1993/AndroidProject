package com.example.vincent.yuejian.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.vincent.yuejian.R;

/**
 * Created by Vincent on 2017/10/30.
 */

public class ScrollPicDetail extends AppCompatActivity {
    private ImageView scroll_pic,svg_back;
    private int pic_pos;
    private int images[] = {
            R.drawable.homeroll_1,
            R.drawable.homeroll_2,
            R.drawable.homeroll_3
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.scroll_detail);
        getlastActivityData();
        initView();;
        svg_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void initView(){
        scroll_pic = (ImageView)findViewById(R.id.scroll_pic);
        svg_back = (ImageView)findViewById(R.id.svg_back);

        scroll_pic.setImageResource(images[pic_pos]);
    }

    private void getlastActivityData(){
        Bundle bundle=this.getIntent().getExtras();
        pic_pos = Integer.valueOf(bundle.getString("picpos"));
//        simp_title.setText(bundle.getString("actname"));

    }
}
