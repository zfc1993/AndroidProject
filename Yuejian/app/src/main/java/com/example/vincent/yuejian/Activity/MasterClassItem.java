package com.example.vincent.yuejian.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vincent.yuejian.R;

/**
 * Created by Vincent on 2017/10/26.
 */

public class MasterClassItem extends AppCompatActivity {
    private ImageView avg_back;
    private TextView simp_title;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.master_class_item_detail);
        initView();
    }
    public void initView(){
        simp_title = (TextView) findViewById(R.id.simp_title);
        avg_back = (ImageView) findViewById(R.id.svg_back);

        simp_title.setText("射箭的好处");

        avg_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
