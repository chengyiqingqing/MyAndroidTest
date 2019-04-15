package com.meitu.sww.testcustomviewcollection.messure;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.meitu.sww.testcustomviewcollection.util.DeviceUtil;

/**
 *
 * @author ShaoWenWen
 * @date 2019/3/24
 */
public class MeasureView extends View{

    private static final String TAG = "MeasureView";
    public int count = 0;

    public MeasureView(Context context) {
        super(context);
    }

    public MeasureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e(TAG, "onMeasure: " + count++);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = measureWidth(widthMeasureSpec);
        int measureHeight = measureheight(heightMeasureSpec);
        setMeasuredDimension(measureWidth, measureHeight);
    }

    private int measureWidth(int widthMeasureSpec) {
        int targetWidth = 0;
        int model = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        Log.e(TAG, "measureWidth: size : " + size);
        Log.e(TAG, "measureWidth: 屏幕宽度：" + DeviceUtil.getScreenWidth());
        if (model == MeasureSpec.EXACTLY){
            targetWidth = size;
        }else if (model == MeasureSpec.AT_MOST){
            targetWidth = 200;
            targetWidth = Math.max(targetWidth,DeviceUtil.getScreenWidth());
        }
        return targetWidth;
    }


    private int measureheight(int heightMeasureSpec) {
        int realHeight = 0;
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);
        Log.e(TAG, "measureheight: size : "+size );
        Log.e(TAG, "measureheight: 屏幕高度：" +DeviceUtil.getScreenHeight((Activity) getContext()));
        if (mode == MeasureSpec.EXACTLY){
            realHeight = size;
        }else if (mode == MeasureSpec.AT_MOST){
            realHeight = 200;
            realHeight = Math.min(realHeight,size);
        }
        return realHeight;
    }

}
