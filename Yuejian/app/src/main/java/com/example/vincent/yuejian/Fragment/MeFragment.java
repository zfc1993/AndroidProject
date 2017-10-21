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

import com.example.vincent.yuejian.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {

//    public TextView name_me,phone_me,btn_post,btn_attention,btn_order,btn_feedback,btn_quit;
//    public LinearLayout intro_me;
//    public ImageView ic_post,id_attention,ic_order,btn_exit,ic_QR;
//    public CircleImageView pic_me;
    public View view = null;
    String uid=null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);
//        initview();
//        getUserSimpData();
        return view;
    }


}
