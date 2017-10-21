package com.example.vincent.yuejian.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;

import com.example.vincent.yuejian.R;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    TextView home_act_btn, home_pro_btn, home_match_btn;
    ImageView act_line,pro_line,match_line;
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
        rollPVhome = (RollPagerView)view.findViewById(R.id.rollPV_home);
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

}
