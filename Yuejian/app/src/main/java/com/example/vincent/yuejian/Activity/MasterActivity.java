package com.example.vincent.yuejian.Activity;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vincent.yuejian.Adapter.MasterAdapter;
import com.example.vincent.yuejian.Adapter.MasterIntroAdapter;
import com.example.vincent.yuejian.Adapter.MasterQAAdapter;
import com.example.vincent.yuejian.Bean.Actbean;
import com.example.vincent.yuejian.Bean.MasterBean;
import com.example.vincent.yuejian.Bean.MasterSimpbean;
import com.example.vincent.yuejian.R;
import com.example.vincent.yuejian.Service.MasterService;
import com.example.vincent.yuejian.network.RetrofitHelper;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;
import android.widget.LinearLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vincent on 2017/10/26.
 */

public class MasterActivity extends AppCompatActivity{
    private TextView title;
    private ImageView back;
    private ImageView master_pic;
    private TextView master_intro;
    private LinearLayout master_class_area;
    private TextView master_class_btn;
    private ImageView master_class_line;
    private LinearLayout master_qa_area;
    private TextView master_qa_btn;
    private ImageView master_qa_line;
    private XRecyclerView master_class_list;
    private LinearLayout qa_submit_area;

    String master_id = null;
    String master_name = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.master_intro);
        initView();
        getDataFromLastActivity();
        getMasterData();
        getClassData();
    }

    public void initView(){
        title = (TextView) findViewById(R.id.simp_title);
        back = (ImageView) findViewById(R.id.svg_back);
        master_pic = (ImageView) findViewById(R.id.master_intro_pic);
        master_intro = (TextView) findViewById(R.id.master_info);

        master_class_area = (LinearLayout) findViewById(R.id.master_class_area);
        master_class_btn = (TextView) findViewById(R.id.master_class_btn);
        master_class_line = (ImageView) findViewById(R.id.master_class_line);

        master_qa_area = (LinearLayout) findViewById(R.id.master_qa_area);
        master_qa_btn = (TextView) findViewById(R.id.master_qa_btn);
        master_qa_line = (ImageView) findViewById(R.id.master_qa_line);

        master_class_list = (XRecyclerView) findViewById(R.id.master_class_list);
        master_class_list.setLayoutManager(new LinearLayoutManager(this));

        qa_submit_area = (LinearLayout) findViewById(R.id.qa_submit_area);

        title.setText("大师");
        master_class_area.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                qa_submit_area.setVisibility(View.INVISIBLE);
                master_qa_btn.setTextColor(0XFFACACAB);
                master_qa_line.setImageResource(R.drawable.line_unchecked);
                master_class_btn.setTextColor(0XFF72BD9C);
                master_class_line.setImageResource(R.drawable.line_checked);
                getClassData();
            }

        });
        master_qa_area.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                qa_submit_area.setVisibility(View.VISIBLE);
                master_class_btn.setTextColor(0XFFACACAB);
                master_class_line.setImageResource(R.drawable.line_unchecked);
                master_qa_btn.setTextColor(0XFF72BD9C);
                master_qa_line.setImageResource(R.drawable.line_checked);
                getQAData();
            }
        });
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
    public void getDataFromLastActivity(){
        Bundle bundle = this.getIntent().getExtras();
        master_id = bundle.getString("master_id");
        master_name = bundle.getString("master_name");
    }

    public void getMasterData() {
        RetrofitHelper retrofit = new RetrofitHelper();
        Call<MasterSimpbean> call = retrofit.builder(MasterService.class).getmmdetil(master_id);
        call.enqueue(new Callback<MasterSimpbean>() {
            @Override
            public void onResponse(Call<MasterSimpbean> call, Response<MasterSimpbean> response) {
                MasterSimpbean mbean = response.body();
                Picasso.with(MasterActivity.this).load("http://115.159.93.244/new18yuejian/Public/upload/" + mbean.getMpic()).into(master_pic);
                master_intro.setText(mbean.getMintro());
            }

            @Override
            public void onFailure(Call<MasterSimpbean> call, Throwable t) {

            }
        });
    }
    /*
    * 无数据库信息
    * 测试用 actbean
    * 之后修改masterintroadapter
    * */
    public void getClassData(){
        List<Actbean> mList = new ArrayList<Actbean>(){};
        mList.add(new Actbean("test1", "name1"));
        mList.add(new Actbean("test2", "name2"));
        mList.add(new Actbean("test3", "name3"));
        master_class_list.setAdapter(new MasterIntroAdapter(this,mList));
    }
    /*
    * 无数据库信息
    * 测试用 actbean
    * 之后修改masterqaadapter
    * */
    public void getQAData(){
        List<Actbean> mList = new ArrayList<Actbean>(){};
        mList.add(new Actbean("test1", "name1"));
        mList.add(new Actbean("test2", "name2"));
        mList.add(new Actbean("test3", "name3"));
        master_class_list.setAdapter(new MasterQAAdapter(this,mList));
    }

}
