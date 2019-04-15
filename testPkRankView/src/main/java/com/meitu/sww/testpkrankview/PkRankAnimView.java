package com.meitu.sww.testpkrankview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * @author ShaoWenWen
 * @date 2019/4/10
 */
public class PkRankAnimView extends FrameLayout {

    // type级别
    private static final int bronze = 1;
    private static final int silver = 2;
    private static final int gold = 3;
    private static final int diamond = 4;
    private static final int king = 5;
    // type级别
    private static final int level_one = 1;
    private static final int level_two = 2;
    private static final int level_three = 3;
    private static final int level_four = 4;
    private static final int level_five = 5;

    private View rootView;
    // 背景
    private ImageView imageBg;
    // 显示信息
    private ImageView imageRankLevel;
    // 排名赛
    private ImageView imageForgound;
    private Handler handler = new Handler(Looper.getMainLooper());

    public PkRankAnimView(@NonNull Context context) {
        this(context, null);
    }

    public PkRankAnimView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        updateView(king,level_two);
    }

    private void initView(Context context) {
        rootView = inflate(context, R.layout.live_rank_anim_view, this);
        imageBg = findViewById(R.id.image_bg);
        imageRankLevel = findViewById(R.id.text_rank_level);
        imageForgound = findViewById(R.id.image_forgound);
    }

    private void updateView(int type,int level) {
        switch (type) {
            case bronze:
                imageBg.setImageResource(R.mipmap.live_pk_rank_anim_bg_bronze);
                if (level == level_one) {
                    imageRankLevel.setImageResource(R.mipmap.live_pk_bronze_level_one);
                } else if (level == level_two) {
                    imageRankLevel.setImageResource(R.mipmap.live_pk_bronze_level_two);
                } else if (level == level_one) {
                    imageRankLevel.setImageResource(R.mipmap.live_pk_bronze_level_three);
                }
                break;
            case silver:
                break;
            case gold:
                break;
            case diamond:
                break;
            case king:
                imageBg.setImageResource(R.mipmap.live_pk_rank_anim_bg_king);
                if (level == level_one) {
                    imageRankLevel.setImageResource(R.mipmap.live_pk_rank_anim_text_level1);
                } else if (level == level_two) {
                    imageRankLevel.setImageResource(R.mipmap.live_pk_rank_anim_text_level2);
                }
                break;
        }
    }

    public void startScaleAnim() {
        rootView.setAlpha(1.0f);
        PropertyValuesHolder objectAnimatorScaleX1 = PropertyValuesHolder.ofFloat("scaleX", 0f, 1.0f);
        PropertyValuesHolder objectAnimatorScaleY1 = PropertyValuesHolder.ofFloat("scaleY", 0f, 1.0f);
        ObjectAnimator scale = ObjectAnimator.ofPropertyValuesHolder(rootView, objectAnimatorScaleX1, objectAnimatorScaleY1);
        scale.setDuration(600);
        scale.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startTranslateAnim(imageForgound);
            }
        });
        scale.start();
    }

    public void startTranslateAnim(View view) {
        view.clearAnimation();
        //平移；
        ObjectAnimator translateLayout = ObjectAnimator.ofFloat(view, "translationX", dip2fpx(-250), dip2fpx(250));
        translateLayout.setDuration(1000);
        translateLayout.start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getContext() != null) {
                    startAlphaAnim(rootView);
                }
            }
        }, 1600);
    }

    public void startAlphaAnim(View view) {
        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0);
        alphaAnim.setDuration(800);
        alphaAnim.start();
    }

    public float dip2fpx(float pDipValue) {
        DisplayMetrics dm = getContext().getApplicationContext().getResources().getDisplayMetrics();
        return pDipValue * dm.density;
    }

    @Override
    protected void onDetachedFromWindow() {
        if (handler != null) handler.removeCallbacksAndMessages(null);
        super.onDetachedFromWindow();
    }

}
