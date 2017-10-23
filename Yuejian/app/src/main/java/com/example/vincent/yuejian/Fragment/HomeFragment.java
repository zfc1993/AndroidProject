package com.example.vincent.yuejian.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vincent.yuejian.Adapter.ActAdapter;
import com.example.vincent.yuejian.Bean.Actbean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jude.rollviewpager.RollPagerView;

import com.example.vincent.yuejian.R;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    TextView home_act_btn, home_pro_btn, home_match_btn;
    ImageView act_line,pro_line,match_line;
    XRecyclerView home_list;
    public View view = null;
    private RollPagerView rollPVhome = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        initview();
        initEvents();
//        getData();
        return view;

    }

    private void initview(){
        home_list = (XRecyclerView) view.findViewById(R.id.activity_list);
        home_list.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        rollPVhome = (RollPagerView)view.findViewById(R.id.rollPV_home);
        home_act_btn = (TextView) view.findViewById(R.id.home_act_btn);
        home_pro_btn = (TextView) view.findViewById(R.id.home_pro_btn);
        home_match_btn = (TextView) view.findViewById(R.id.home_match_btn);
        act_line= (ImageView) view.findViewById(R.id.act_line);
        pro_line= (ImageView) view.findViewById(R.id.pro_line);
        match_line= (ImageView) view.findViewById(R.id.match_line);

        // 注册监听器
        home_act_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                resetTextColor();
                resetLineColor();
                home_act_btn.setTextColor(0XFF72BD9C);
                act_line.setImageResource(R.drawable.line_checked);
                getData();
            }
        });

        home_pro_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTextColor();
                home_pro_btn.setTextColor(0XFF72BD9C);
                resetLineColor();
                pro_line.setImageResource(R.drawable.line_checked);
            }
        });

        home_match_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTextColor();
                home_match_btn.setTextColor(0XFF72BD9C);
                resetLineColor();
                match_line.setImageResource(R.drawable.line_checked);
            }
        });
    }

    private void initEvents(){
        rollPVhome.setPlayDelay(3000);
        //设置图片切换动画时间
        rollPVhome.setAnimationDurtion(500);
        //设置指示器：
        //rollPV.setHintView(new IconHintView());
        //rollPV.setHintView(new IconHintView(this,R.mipmap.ic_launcher,R.mipmap.ic_launcher));
        rollPVhome.setHintView(new ColorPointHintView(getActivity(),
                getResources().getColor(R.color.colorPrimary),
                Color.WHITE));
        //设置适配器
        rollPVhome.setAdapter(new RollPagerAdapter());
        //设置每一个图片的点击事件
        /*rollPV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity(), "点击了图片"+position, Toast.LENGTH_SHORT).show();

            }
        });*/
    }
    private int images[] = {
            R.drawable.homeroll_1,
            R.drawable.homeroll_2,
            R.drawable.homeroll_3
    };

    //设置适配器
    private class RollPagerAdapter extends StaticPagerAdapter {

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            //设置图片资源
            view.setImageResource(images[position]);
            //设置高度和宽度
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            //设置拉伸方式
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return view;
        }

        @Override
        public int getCount() {
            return images.length;
        }
    }

    private void resetTextColor() {
        home_act_btn.setTextColor(0XFFACACAB);
        home_match_btn.setTextColor(0XFFACACAB);
        home_pro_btn.setTextColor(0XFFACACAB);
    }

    private  void resetLineColor(){
        act_line.setImageResource(R.drawable.line_unchecked);
        pro_line.setImageResource(R.drawable.line_unchecked);
        match_line.setImageResource(R.drawable.line_unchecked);
    }

    public void getData(){
        List<Actbean> mList = new ArrayList<Actbean>(){};
        mList.add(new Actbean("test1", "name1"));
        mList.add(new Actbean("test2", "name2"));
        home_list.setAdapter(new ActAdapter(this.getActivity(), mList));
    }

}
