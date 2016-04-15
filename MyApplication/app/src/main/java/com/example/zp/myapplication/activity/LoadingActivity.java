package com.example.zp.myapplication.activity;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.zp.myapplication.R;
import com.example.zp.myapplication.util.FileUtil;

/**
 * Created by ZHANGPING129 on 2016-04-12.
 */
public class LoadingActivity extends Activity {
    private ImageView mImageView;
    private final static int STARTNEXT=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //设置没有title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_loading);
        mImageView=(ImageView)findViewById(R.id.ic_loading_bg);
       // Picasso.with(this).load(R.drawable.ic_loading).into(mImageView);
        mImageView.setBackgroundResource(R.mipmap.ic_loading);
        FileUtil.createrAlbum();//创建相册
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Message ms = new Message();
                ms.what = STARTNEXT;
                mHandler.sendMessage(ms);
            }
        }, 5000);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

     Handler  mHandler =new Handler(){
         @Override
         public void handleMessage(Message msg) {
             super.handleMessage(msg);
             switch(msg.what){
                 case STARTNEXT:
                     MainActivity.jumpToMainActivity(LoadingActivity.this);
                     finish();
                     break;
             }
         }
     };
}
