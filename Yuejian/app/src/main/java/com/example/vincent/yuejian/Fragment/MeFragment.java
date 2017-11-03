package com.example.vincent.yuejian.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vincent.yuejian.Activity.AboutYJActivity;
import com.example.vincent.yuejian.Activity.OrderActivity;
import com.example.vincent.yuejian.Activity.PostActivity;
import com.example.vincent.yuejian.Activity.Setting;
import com.example.vincent.yuejian.Activity.ScrollPicDetail;
import com.example.vincent.yuejian.Activity.SubscribeActivity;
import com.example.vincent.yuejian.R;

import retrofit2.http.POST;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {

//    public TextView name_me,phone_me,btn_post,btn_attention,btn_order,btn_feedback,btn_quit;
//    public LinearLayout intro_me;
//    public ImageView ic_post,id_attention,ic_order,btn_exit,ic_QR;
//    public CircleImageView pic_me;
    private LinearLayout post_area;
    private LinearLayout subscribe_area;
    private LinearLayout order_area;
    private LinearLayout about_area, setting_area, scan_area;
    public View view = null;
    String uid=null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);
        initView();
//        getUserSimpData();
        return view;
    }

    public void initView(){
        post_area = (LinearLayout) view.findViewById(R.id.post_area);
        subscribe_area = (LinearLayout) view.findViewById(R.id.subscribe_area);
        order_area = (LinearLayout) view.findViewById(R.id.order_area);
        about_area = (LinearLayout) view.findViewById(R.id.about_area);
        setting_area = (LinearLayout) view.findViewById(R.id.setting_area);
        scan_area = (LinearLayout) view.findViewById(R.id.scan_area);

        post_area.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), PostActivity.class);

                getActivity().startActivity(intent);
            }
        });
        subscribe_area.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), SubscribeActivity.class);

                getActivity().startActivity(intent);
            }
        });
        order_area.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), OrderActivity.class);

                getActivity().startActivity(intent);
            }
        });


        about_area.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), AboutYJActivity.class);

                getActivity().startActivity(intent);
            }
        });

        setting_area.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), Setting.class);

                getActivity().startActivity(intent);
            }
        });
    }


}
