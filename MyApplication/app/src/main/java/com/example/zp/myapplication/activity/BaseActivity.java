package com.example.zp.myapplication.activity;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zp.myapplication.R;

/**
 * Created by ZHANGPING129 on 2016-04-12.
 */
public class BaseActivity extends AppCompatActivity {


    protected  void showTotast(String str){
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
    }

    protected  void showToast(String str,int duration){
        Toast.makeText(this,str,duration).show();
    }

    protected void showSnackBar( String content, String actionText, View.OnClickListener onClickListener) {
        View contentView = getFirstChildView(this);
        Snackbar snackbar = Snackbar.make(contentView, content, Snackbar.LENGTH_LONG);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        layout.setPadding(0, 25, 0, 25);
        TextView tipsTextView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
        TextPaint paint = tipsTextView.getPaint();
        paint.setFakeBoldText(true);//设置粗体
        tipsTextView.setTextSize(16);
        tipsTextView.setTextColor(this.getResources().getColor(R.color.cyan));
        layout.setBackgroundColor(this.getResources().getColor(R.color.white));
        if (null == actionText) {
            snackbar.show();
        } else {
            snackbar.setAction(actionText, onClickListener);
            snackbar.setActionTextColor(getResources().getColor(R.color.cyan));
            snackbar.show();
        }

    }


    private View getFirstChildView(Context context){
    return ((ViewGroup)((ViewGroup)getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0)).getChildAt(0);
    }
}
