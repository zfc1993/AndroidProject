package com.example.vincent.yuejian.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.vincent.yuejian.R;

public class ApplyActivity extends AppCompatActivity {
    private ImageView appBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        initView();
        appBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
    public void initView(){
        appBack = (ImageView)findViewById(R.id.svg_back);
    }
}
