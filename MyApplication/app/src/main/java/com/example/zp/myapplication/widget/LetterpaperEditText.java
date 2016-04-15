package com.example.zp.myapplication.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.zp.myapplication.R;

/**
 * Created by ZHANGPING129 on 2016-04-14.
 */
public class LetterpaperEditText extends EditText {
    public LetterpaperEditText(Context context) {
        super(context);
    }

    public LetterpaperEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LetterpaperEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LetterpaperEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint mPaint = getPaint();
        mPaint.setColor(getResources().getColor(R.color.black));
        int mLineCount;
        int startX=getPaddingLeft();
        float startY=0;
        int defaultCount=getHeight()/getLineHeight();
        if(defaultCount<getLineCount()){
            mLineCount=getLineCount();
        }else{
            mLineCount=defaultCount;
        }
        for(int i=0;i<mLineCount+1;i++){
            startY=(getLineHeight())*i;
            canvas.drawLine(startX,startY,getRight()-getPaddingRight(),startY,mPaint);
        }
        canvas.translate(0,0);
        super.onDraw(canvas);
    }


}
