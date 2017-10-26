package com.example.vincent.yuejian.Activity;

/**
 * Created by Vincent on 2017/10/25.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//import com.neusoft.yuejian26.yuejian_26.Bean.ActSimpbean;
import com.example.vincent.yuejian.Bean.ClubSimpbean;
import com.example.vincent.yuejian.Bean.MatchSimpbean;
import com.example.vincent.yuejian.Bean.Matchbean;
import com.example.vincent.yuejian.R;
import com.example.vincent.yuejian.Service.ActivityService;
import com.example.vincent.yuejian.Service.ClubService;
import com.example.vincent.yuejian.Service.MatchService;
import com.example.vincent.yuejian.network.RetrofitHelper;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchSimpActivity extends AppCompatActivity {

    TextView simp_title,simp_match_name,simp_match_time,simp_match_club;
    ImageView match_simp_pic,svg_back;
    String gid=null;
    String clubid=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_simp);
        intview();
        getlastMatchData();
        getMatchSimpData();
        svg_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void getMatchSimpData() {
        RetrofitHelper retrofit = new RetrofitHelper();
        Call<MatchSimpbean> call =retrofit.builder(MatchService.class).getMatchsimp(gid);
        call.enqueue(new Callback<MatchSimpbean>() {
            @Override
            public void onResponse(Call<MatchSimpbean> call, Response<MatchSimpbean> response) {
                MatchSimpbean mtsimpdata=response.body();
                getClubName(mtsimpdata.getClubid());
                Picasso.with(MatchSimpActivity.this).load("http://115.159.93.244/new18yuejian/Public/upload/"+mtsimpdata.getGpic()).into(match_simp_pic);
                simp_match_name.setText(mtsimpdata.getGname());
                simp_match_time.setText(mtsimpdata.getGdata());
                //simp_match_club.setText(mtsimpdata.getClubid());
            }

            @Override
            public void onFailure(Call<MatchSimpbean> call, Throwable t) {

            }
        });
    }

    private void getClubName(String clubid){
        RetrofitHelper retrofit = new RetrofitHelper();
        Call<ClubSimpbean> call =retrofit.builder(ClubService.class).getClubsimp(clubid);
        call.enqueue(new Callback<ClubSimpbean>() {
            @Override
            public void onResponse(Call<ClubSimpbean> call, Response<ClubSimpbean> response) {
                ClubSimpbean clsimpdata=response.body();
                simp_match_club.setText(clsimpdata.getClubname());
            }

            @Override
            public void onFailure(Call<ClubSimpbean> call, Throwable t) {

            }
        });
    }

    private void getlastMatchData(){
        Bundle bundle=this.getIntent().getExtras();
        gid = bundle.getString("matchiid");
        simp_title.setText(bundle.getString("matchname"));
    }

    private  void intview(){
        svg_back =(ImageView) findViewById(R.id.svg_back);
        match_simp_pic=(ImageView) findViewById(R.id.match_simp_pic);
        simp_title=(TextView) findViewById(R.id.simp_title);
        simp_match_name=(TextView) findViewById(R.id.simp_match_name);
        simp_match_time=(TextView) findViewById(R.id.simp_match_time);
        simp_match_club=(TextView) findViewById(R.id.simp_match_club);
    }



}

