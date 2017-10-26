package com.example.vincent.yuejian.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vincent.yuejian.Bean.ActSimpbean;
import com.example.vincent.yuejian.R;
import com.example.vincent.yuejian.Service.ActivityService;
import com.example.vincent.yuejian.network.RetrofitHelper;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActSimpActivity extends AppCompatActivity {

    TextView simp_title,simp_act_name,simp_act_address,simp_act_time,simp_act_cost,simp_act_tel,simp_info;
    RelativeLayout btn_apply;
    ImageView act_simp_pic,svg_back;
    String actid=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_act_simp);
        intview();
        getlastActivityData();
        getActSimpData();
        svg_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void getActSimpData() {
        RetrofitHelper retrofit = new RetrofitHelper();
        Call<ActSimpbean> call =retrofit.builder(ActivityService.class).getactsimp(actid);
        call.enqueue(new Callback<ActSimpbean>() {
            @Override
            public void onResponse(Call<ActSimpbean> call, Response<ActSimpbean> response) {
                ActSimpbean msimpdata= response.body();
                Picasso.with(ActSimpActivity.this).load("http://115.159.93.244/new18yuejian/Public/upload/"+msimpdata.getActpic()).into(act_simp_pic);
                simp_act_name.setText(msimpdata.getAname());
                simp_act_address.setText(msimpdata.getActaddress());
                simp_act_time.setText(msimpdata.getActdata());
                simp_act_cost.setText(msimpdata.getActp()+"/人");
                simp_act_tel.setText(msimpdata.getActpone());
                simp_info.setText(msimpdata.getActintro());
            }

            @Override
            public void onFailure(Call<ActSimpbean> call, Throwable t) {

            }
        });
    }

    private void getlastActivityData(){
        Bundle bundle=this.getIntent().getExtras();
        actid = bundle.getString("actiid");
        simp_title.setText(bundle.getString("actname"));

    }

    private  void intview(){
        svg_back =(ImageView) findViewById(R.id.svg_back);
        act_simp_pic=(ImageView) findViewById(R.id.act_simp_pic);
        simp_title=(TextView) findViewById(R.id.simp_title);
        simp_act_name=(TextView) findViewById(R.id.simp_act_name);
        simp_act_address=(TextView) findViewById(R.id.simp_act_address);
        simp_act_time=(TextView) findViewById(R.id.simp_act_time);
        simp_act_cost=(TextView) findViewById(R.id.simp_act_cost);
        simp_act_tel=(TextView) findViewById(R.id.simp_act_tel);
        simp_info=(TextView) findViewById(R.id.simp_info);
        btn_apply=(RelativeLayout) findViewById(R.id.btn_apply);
        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActSimpActivity.this, ApplyActivity.class);
                startActivity(intent);
            }
        });
    }
}
