package com.meitu.sww.myviewaddandremove;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

/**
 * @author ShaoWenWen
 * @date 2019/4/10
 */
public class AnimationView extends RelativeLayout {


    public AnimationView(Context context) {
        this(context, null);
    }

    public AnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.anim_layout, this);
    }

    public void startAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 1.4f, 1, 1.4f, 0.5f, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatCount(4);
        scaleAnimation.setRepeatMode(Animation.REVERSE); this.startAnimation(scaleAnimation);
    }

    public void endAnimation(){
        this.clearAnimation();
    }

}
