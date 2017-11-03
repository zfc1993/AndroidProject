package com.example.vincent.yuejian.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vincent.yuejian.R;

/**
 * Created by Vincent on 2017/10/31.
 */

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.settings);
        initView();
//        getlastActivityData();
//        getActSimpData();

    }

    public void initView(){

    }
}
