package com.example.vincent.yuejian.Activity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vincent.yuejian.Adapter.ActAdapter;
import com.example.vincent.yuejian.Adapter.PostAdapter;
import com.example.vincent.yuejian.Bean.Actbean;
import com.example.vincent.yuejian.Bean.PostBean;
import com.example.vincent.yuejian.R;
import com.example.vincent.yuejian.Service.ActivityService;
import com.example.vincent.yuejian.Service.PostService;
import com.example.vincent.yuejian.network.RetrofitHelper;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vincent on 2017/10/30.
 */

public class PostActivity extends AppCompatActivity{
    private XRecyclerView post_list;
    private Context pContext;
    private ImageView svg_back;
    private TextView simp_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.post);
        initView();
//        getlastActivityData();
//        getActSimpData();
/*        svg_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
        getPostData();

    }

    public void initView(){
        pContext = this;
        post_list = (XRecyclerView) findViewById(R.id.post_list);
        post_list.setLayoutManager(new LinearLayoutManager(this));
        simp_title = (TextView) findViewById(R.id.simp_title);
        svg_back = (ImageView) findViewById(R.id.svg_back);
        svg_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        simp_title.setText("发帖");
    }

    public void getPostData(){
        RetrofitHelper retrofit = new RetrofitHelper();
        Call<List<PostBean>> call = retrofit.builder(PostService.class).getpostlist(String.valueOf(1));
        call.enqueue(new Callback<List<PostBean>>() {
            @Override
            public void onResponse(Call<List<PostBean>> call, Response<List<PostBean>> response) {
                List<PostBean> mlist = response.body();
                post_list.setAdapter(new PostAdapter(pContext, mlist));;
            }
            @Override
            public void onFailure(Call<List<PostBean>> call, Throwable t) {
                List<PostBean> mList = new ArrayList<PostBean>(){};
                mList.add(new PostBean("test1", "name1"));
                mList.add(new PostBean("test2", "name2"));
                post_list.setAdapter(new PostAdapter(pContext, mList));
            }
        });
    }
}
