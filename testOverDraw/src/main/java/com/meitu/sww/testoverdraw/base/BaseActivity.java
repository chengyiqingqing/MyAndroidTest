package com.meitu.sww.testoverdraw.base;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.meitu.sww.testoverdraw.R;

/**
 * @author ShaoWenWen
 * @date 2019/1/3
 */
public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTranslucentStatusBar(true);
    }

    /**
     * 设置浸透状态栏
     * @param isLightBar true 状态栏字体会显示为黑色 false 会显示白色
     */
    public void initTranslucentStatusBar(boolean isLightBar) {
        initTranslucentStatusBar(isLightBar, false);
    }

    /**
     * 设置浸透状态栏
     * @param isLightBar true 状态栏字体会显示为黑色 false 会显示白色
     * @param isSetDefaultBackground 是否设置状态栏默认背景（因为6.0以下的设备中不能更改状态栏字体颜色，部分小米 oppo设备可以更改，不过这里统一设置，
     * 为了避免背景是白色 状态栏字体是白色导致的视觉问题）
     */
    @SuppressLint("MissingBraces")
    public void initTranslucentStatusBar(boolean isLightBar, boolean isSetDefaultBackground) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (isLightBar)
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                else getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                if (isSetDefaultBackground) addDefaultStatusBarBackground();
            } else {
                if (isSetDefaultBackground) addDefaultStatusBarBackground();
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            }
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
        // 隐藏ActionBar
        if (getSupportActionBar() != null) getSupportActionBar().hide();
    }

    private void addDefaultStatusBarBackground() {
        View view = new View(this);
        view.setLayoutParams(new ViewGroup.LayoutParams(Resources.getSystem().getDisplayMetrics().widthPixels,
                getStatusBarHeight()));
        view.setBackgroundColor(getResources().getColor(R.color.live_tran40_black));
        ((ViewGroup) getWindow().getDecorView()).addView(view);
    }

    public void removeStatusView(){
        ((ViewGroup) getWindow().getDecorView()).removeViewAt(((ViewGroup) getWindow().getDecorView()).getChildCount()-1);
    }

    public static int getStatusBarHeight() {
        int resourceId = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
        return resourceId > 0 ? Resources.getSystem().getDimensionPixelSize(resourceId) : 0;
    }

}
