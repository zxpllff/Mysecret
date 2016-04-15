package com.example.zp.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.zp.myapplication.R;
import com.example.zp.myapplication.fragment.AlbumFragment;
import com.example.zp.myapplication.fragment.CreaterFragment;
import com.example.zp.myapplication.fragment.WebViewFragment;

import java.util.jar.Manifest;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        private FragmentManager mFragmentManager;
        private FrameLayout mFrameLayout;
        private String currentFramentName=WebViewFragment.class.getSimpleName();
        private final static int EXITAPP=0;

    public static void jumpToMainActivity(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//绑定布局文件，指定当前activity加载哪个布局文件
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);//从布局文件中获取控件
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() { //为FloatingAcitonButton 设置点击监听事件
            @Override
            public void onClick(View view) {
                CreateActivity.jumpToMainActivity(MainActivity.this);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();//该方法会自动和actionBar关联, 将开关的图片显示在了action上，如果不设置，也可以有抽屉的效果，不过是默认的图标

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mFragmentManager= getSupportFragmentManager();
        addFragment();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            replaceFragment(AlbumFragment.class.getSimpleName());
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void addFragment(){
       Fragment mFragment=mFragmentManager.findFragmentByTag(WebViewFragment.class.getSimpleName());
        if(mFragment==null){
            WebViewFragment mWebViewFragment= new WebViewFragment();
            mFragmentManager.beginTransaction().add(R.id.frame_layout, mWebViewFragment, WebViewFragment.class.getSimpleName()).commitAllowingStateLoss();
            currentFramentName=WebViewFragment.class.getSimpleName();
        }
    }

    private void replaceFragment(String fragmentName){
        hideFragment();
        Fragment mFragment=mFragmentManager.findFragmentByTag(fragmentName);
        currentFramentName=fragmentName;
        if(mFragment!=null){
            mFragmentManager.beginTransaction().show(mFragment).commitAllowingStateLoss();
        }else{
            if(AlbumFragment.class.getSimpleName().equals(fragmentName)){
                mFragment= new AlbumFragment();
            }else if(CreaterFragment.class.getSimpleName().equals(fragmentName)){
                mFragment= new CreaterFragment();
            }

            mFragmentManager.beginTransaction().add(R.id.frame_layout, mFragment, AlbumFragment.class.getSimpleName()).commitAllowingStateLoss();
        }
    }

    private void hideFragment(){
        Fragment mFragment=   mFragmentManager.findFragmentByTag(currentFramentName);
        if(mFragment!=null){
            mFragmentManager.beginTransaction().hide(mFragment).commitAllowingStateLoss();
        }
    }


    boolean isExit=false;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if(isExit){
                finish();
            }else{
                showSnackBar("再按一次退出app",null,null);
                isExit=true;
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Message mg= new Message();
                        mg.what=EXITAPP;
                        mHandler.sendMessage(mg);
                    }
                },2000);
        }
            return  true;
        }else{
            return super.onKeyDown(keyCode, event);
        }

    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case EXITAPP:
                    isExit=false;
                    break;
            }

        }
    };
}
