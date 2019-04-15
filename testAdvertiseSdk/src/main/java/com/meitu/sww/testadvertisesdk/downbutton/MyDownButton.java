package com.meitu.sww.testadvertisesdk.downbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.meitu.sww.testadvertisesdk.R;

/**
 * 一会儿写一个样式控制的controller;
 * @author ShaoWenWen
 * @date 2019/4/4
 */
public class MyDownButton extends RelativeLayout {

    private static final int INTERVAL = 500;

    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int operateCount = 0;
    private Handler handler = new Handler(Looper.getMainLooper());

    private DownloadButtonModel downloadButtonModel;

    public MyDownButton(Context context) {
        this(context, null);
    }

    public MyDownButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributeSet(context, attrs);
        initView(context);
        initListener();
    }

    private void initAttributeSet(Context context, AttributeSet attrs) {
        downloadButtonModel = new DownloadButtonModel();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyDownButtonStyle);
        downloadButtonModel.setTextColor(typedArray.getColor(R.styleable.MyDownButtonStyle_textColor, 0));
        downloadButtonModel.setTextSize(typedArray.getDimension(R.styleable.MyDownButtonStyle_textSize, 0));
        downloadButtonModel.setButtonStrokeColor(typedArray.getColor(R.styleable.MyDownButtonStyle_buttonStrokeColor, 0));
        downloadButtonModel.setButtonStrokeWidth(typedArray.getDimension(R.styleable.MyDownButtonStyle_buttonStrokeWidth, 0));
        downloadButtonModel.setButtonWidth(typedArray.getDimension(R.styleable.MyDownButtonStyle_buttonWidth, 0));
        downloadButtonModel.setButtonHeight(typedArray.getDimension(R.styleable.MyDownButtonStyle_buttonHeight, 0));
        downloadButtonModel.setButtonBackground(typedArray.getDrawable(R.styleable.MyDownButtonStyle_buttonBackground));
        downloadButtonModel.setCorner(typedArray.getDimension(R.styleable.MyDownButtonStyle_corner, 0));
        typedArray.recycle();
    }

    private void initView(Context context) {
        inflate(context, R.layout.dl_omni_download_button, this);
        mProgressBar = findViewById(R.id.progress_download);
        mTextView = findViewById(R.id.text_download);
        initViewByAttribute(downloadButtonModel);
    }

    private void initListener() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operateCount == 0) {
                    updateViewStatus();
                }
                if (operateCount == 1) {
                    showProgress();
                }
                operateCount++;
            }
        });
    }

    /**
     * 为外界提供该下载按钮设置属性
     */
    public void initViewByAttribute(final DownloadButtonModel downloadButtonModel) {
        if (downloadButtonModel == null) return;
        if (downloadButtonModel.getTextColor() != 0) mTextView.setTextColor(downloadButtonModel.getTextColor());
        if (downloadButtonModel.getTextSize() != 0) mTextView.setTextSize(downloadButtonModel.getTextSize());
//                    GradientDrawable gradientDrawable = (GradientDrawable) mProgressBar.getProgressDrawable();
        Drawable drawable = mProgressBar.getProgressDrawable();

//        updateGradientDrawable(drawable);
        updateLayerDrawable(drawable);
        /*handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setProgressDrawable(gradientDrawable);
            }
        },2000);*/

    }

    private void updateLayerDrawable(Drawable drawable) {
        Log.e(TAG, "updateLayerDrawable: instanceof --- " + (drawable instanceof LayerDrawable));
        Log.e(TAG, "updateLayerDrawable: isInstance ---- " + (LayerDrawable.class.isInstance(drawable)));
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            if (layerDrawable.getNumberOfLayers()==2){
//                Drawable drawable1 = layerDrawable.getDrawable(layerDrawable.getNumberOfLayers()-1);
//                Log.e(TAG, "updateLayerDrawable: clip --- "+(drawable1 instanceof ClipDrawable) );
//                Log.e(TAG, "updateLayerDrawable: gradient --- "+(drawable1 instanceof GradientDrawable) );
                ClipDrawable clipDrawable = (ClipDrawable) layerDrawable.getDrawable(layerDrawable.getNumberOfLayers()-1);
                if (android.os.Build.VERSION.SDK_INT >= 23) {
                    GradientDrawable gradientDrawable = (GradientDrawable) clipDrawable.getDrawable();
                    gradientDrawable.setColors(new int[]{Color.RED, Color.GREEN, Color.BLUE});
                }
                //                clipDrawable.set(new int[]{Color.RED, Color.GREEN, Color.BLUE});
            }
            Log.e(TAG, "updateLayerDrawable: " + layerDrawable.getNumberOfLayers());
        }
    }

    private static final String TAG = "MyDownButton";
    public void updateGradientDrawable(Drawable drawable) {
        Log.e(TAG, "updateGradientDrawable: " + (drawable instanceof GradientDrawable));
        Log.e(TAG, "updateGradientDrawable: " + (GradientDrawable.class.isInstance(drawable)));
        if (drawable instanceof GradientDrawable) {
            //            GradientDrawable gradientDrawable = (GradientDrawable) mProgressBar.getProgressDrawable();
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            if (gradientDrawable == null) return;
            // 设置边框的颜色和宽度；
            if (downloadButtonModel.getButtonStrokeWidth() != 0 && downloadButtonModel.getButtonStrokeColor() != 0) {
                gradientDrawable.setStroke((int) downloadButtonModel.getButtonStrokeWidth(), downloadButtonModel.getButtonStrokeColor());
            }
            if (downloadButtonModel.getCorner() != 0) {
                gradientDrawable.setCornerRadius(downloadButtonModel.getCorner());
            }
            // 为GradientDrawable设置渐变色
            gradientDrawable.setColors(new int[]{Color.RED, Color.GREEN, Color.BLUE});
        }
    }

    public void updateViewStatus() {
        mTextView.setCompoundDrawables(null, null, null, null);
        mProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.dl_progress_active_gradient));
    }

    public void showProgress() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setProgress(operateCount++);
                if (operateCount >= 98) return;
                showProgress();
            }
        }, INTERVAL);
    }

}
