package com.example.zp.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zp.myapplication.R;
import com.example.zp.myapplication.widget.LetterpaperEditText;

/**
 * Created by ZHANGPING129 on 2016-04-13.
 */
public class CreateActivity extends BaseActivity {

    private ImageView mIgWeather;
    private TextView mTvWeather;
    private TextView mTvWeatherNotice;
    private LetterpaperEditText mEdSecret;


    public static void jumpToMainActivity(Context context){
        Intent intent = new Intent(context,CreateActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_creater);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mIgWeather=(ImageView)findViewById(R.id.weather_img);
        mTvWeather=(TextView)findViewById(R.id.temperature_tv);
        mTvWeatherNotice=(TextView)findViewById(R.id.weather_notice_tv);
        mEdSecret=(LetterpaperEditText)findViewById(R.id.secret_ed);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
