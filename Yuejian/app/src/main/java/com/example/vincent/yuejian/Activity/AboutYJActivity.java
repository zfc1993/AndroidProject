package com.example.vincent.yuejian.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vincent.yuejian.R;

import org.w3c.dom.Text;

/**
 * Created by Vincent on 2017/10/30.
 */

public class AboutYJActivity extends AppCompatActivity {
    private ImageView svg_back;
    private TextView simp_title;
    private LinearLayout about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.about_yj);
        initView();
//        getlastActivityData();
//        getActSimpData();

    }

    public void initView(){
        svg_back = (ImageView)findViewById(R.id.svg_back);
        simp_title = (TextView) findViewById(R.id.simp_title);
        about = (LinearLayout) findViewById(R.id.about);

        about.getBackground().setAlpha(120);
        simp_title.setText("关于约健体育");
        svg_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
