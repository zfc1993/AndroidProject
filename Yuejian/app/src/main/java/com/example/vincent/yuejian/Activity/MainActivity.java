package com.example.vincent.yuejian.Activity;

/**
 * Created by Vincent on 2017/10/20.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vincent.yuejian.R;

import android.support.v4.app.FragmentActivity;
import com.example.vincent.yuejian.Fragment.HomeFragment;
import com.example.vincent.yuejian.Fragment.TrainFragment;
import com.example.vincent.yuejian.Fragment.ClubFragment;
import com.example.vincent.yuejian.Fragment.ShareFragment;
import com.example.vincent.yuejian.Fragment.MeFragment;


public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private LinearLayout mTabHome,mTabTrain,mTabClub,mTabShare,mTabMe;
    private ImageButton mImgHome,mImgTrain,mImgClub,mImgShare,mImgMe;
    private TextView mTextHome,mTextTrain,mTextClub,mTextShare,mTextMe;
    private Fragment mTab01,mTab02,mTab03,mTab04,mTab05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        setSelect(0);
    }
    //初始化视图
    private void initView(){
        this.mTabHome = (LinearLayout)findViewById(R.id.id_tab_home);
        mTabTrain = (LinearLayout) findViewById(R.id.id_tab_train);
        mTabClub = (LinearLayout) findViewById(R.id.id_tab_club);
        mTabShare = (LinearLayout) findViewById(R.id.id_tab_share);
        mTabMe = (LinearLayout) findViewById(R.id.id_tab_me);

        mImgHome = (ImageButton) findViewById(R.id.id_tab_home_img);
        mImgTrain = (ImageButton) findViewById(R.id.id_tab_train_img);
        mImgClub = (ImageButton) findViewById(R.id.id_tab_club_img);
        mImgShare = (ImageButton) findViewById(R.id.id_tab_share_img);
        mImgMe = (ImageButton) findViewById(R.id.id_tab_me_img);

        mTextHome=(TextView)findViewById(R.id.id_tab_home_text);
        mTextTrain=(TextView)findViewById(R.id.id_tab_train_text);
        mTextClub=(TextView)findViewById(R.id.id_tab_club_text);
        mTextShare=(TextView)findViewById(R.id.id_tab_share_text);
        mTextMe=(TextView)findViewById(R.id.id_tab_me_text);
    }
    //初始化待监听事件
    private void initEvent(){
        mTabHome.setOnClickListener(this);
        mTabTrain.setOnClickListener(this);
        mTabClub.setOnClickListener(this);
        mTabShare.setOnClickListener(this);
        mTabMe.setOnClickListener(this);
    }

    private void setSelect(int index){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch(index){
            case 0:
                if (mTab01 == null)
                {
                    mTab01 = new HomeFragment();
                    transaction.add(R.id.id_content, mTab01);
                } else
                {
                    transaction.show(mTab01);
                }
                mImgHome.setImageResource(R.drawable.ic_home);
                //resetTextColor();
                mTextHome.setTextColor(0XFF72BD9C);
                break;
            case 1:
                if (mTab02 == null)
                {
                    mTab02 = new TrainFragment();
                    transaction.add(R.id.id_content, mTab02);
                } else
                {
                    transaction.show(mTab02);

                }
                mImgTrain.setImageResource(R.drawable.ic_train);
                //resetTextColor();
                mTextTrain.setTextColor(0XFF72BD9C);
                break;
            case 2:
                if (mTab03 == null)
                {
                    mTab03 = new ClubFragment();
                    transaction.add(R.id.id_content, mTab03);
                } else
                {
                    transaction.show(mTab03);
                }
                mImgClub.setImageResource(R.drawable.ic_club);
                //resetTextColor();
                mTextClub.setTextColor(0XFF72BD9C);
                break;
            case 3:
                if (mTab04 == null)
                {
                    mTab04 = new ShareFragment();
                    transaction.add(R.id.id_content, mTab04);
                } else
                {
                    transaction.show(mTab04);
                }
                mImgShare.setImageResource(R.drawable.ic_share);
                //resetTextColor();
                mTextShare.setTextColor(0XFF72BD9C);
                break;
            case 4:
                if (mTab05 == null)
                {
                    mTab05 = new MeFragment();
                    transaction.add(R.id.id_content, mTab05);
                } else
                {
                    transaction.show(mTab05);
                }
                mImgMe.setImageResource(R.drawable.ic_me);
                //resetTextColor();
                mTextMe.setTextColor(0XFF72BD9C);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction)
    {
        if (mTab01 != null)
        {
            transaction.hide(mTab01);
        }
        if (mTab02 != null)
        {
            transaction.hide(mTab02);
        }
        if (mTab03 != null)
        {
            transaction.hide(mTab03);
        }
        if (mTab04 != null)
        {
            transaction.hide(mTab04);
        }
        if (mTab05 != null)
        {
            transaction.hide(mTab05);
        }
    }

    @Override
    public void onClick(View v)
    {
        resetImages();
        resetTextColor();
        switch (v.getId())
        {
            case R.id.id_tab_home:
                setSelect(0);
                break;
            case R.id.id_tab_train:
                setSelect(1);
                break;
            case R.id.id_tab_club:
                setSelect(2);
                break;
            case R.id.id_tab_share:
                setSelect(3);
                break;
            case R.id.id_tab_me:
                setSelect(4);
                break;

            default:
                break;
        }
    }

    private void resetImages(){
        mImgHome.setImageResource(R.drawable.ic_home_unchecked);
        mImgTrain.setImageResource(R.drawable.ic_train_unchecked);
        mImgClub.setImageResource(R.drawable.ic_club_unchecked);
        mImgShare.setImageResource(R.drawable.ic_share_unchecked);
        mImgMe.setImageResource(R.drawable.ic_me_unchecked);
    }

    private void resetTextColor(){
        mTextHome.setTextColor(getResources().getColor(R.color.colorUnChecked));
        // 0XFFACACAB 这是啥玩儿？
        mTextTrain.setTextColor(0XFFACACAB);
        mTextClub.setTextColor(0XFFACACAB);
        mTextShare.setTextColor(0XFFACACAB);
        mTextMe.setTextColor(0XFFACACAB);
    }
}
