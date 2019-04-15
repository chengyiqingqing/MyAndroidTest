package com.meitu.sww.testpkrankview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author ShaoWenWen
 * @date 2019/4/10
 */
public class PkRankView extends FrameLayout {

    private ImageView imageBg;
    private TextView textRankLevel;

    private int type;

    public PkRankView(@NonNull Context context) {
        this(context, null);
    }

    public PkRankView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initListener();
    }

    private void initView(Context context) {
        inflate(context, R.layout.live_rank_view, this);
        imageBg = findViewById(R.id.image_bg);
        textRankLevel = findViewById(R.id.text_rank_level);
    }

    private void initListener() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                type++;
                if (type == 4) type = 1;
                updateView();
            }
        });
    }

    public void setBackgound() {
        textRankLevel.setBackgroundColor(Color.BLUE);
    }

    public void updateView() {
        if (type == 1) {
            imageBg.setImageResource(R.mipmap.type1);
            setTextMarginRight(dip2px(13));
            textRankLevel.setText("青铜Ⅱ");
            textRankLevel.setTextColor(getResources().getColor(R.color.color_FCDCD8));
        } else if (type == 2) {
            imageBg.setImageResource(R.mipmap.type3);
            setTextMarginRight(dip2px(4));
            textRankLevel.setText("王者x999");
            textRankLevel.setTextColor(getResources().getColor(R.color.color_FCDCD8));
        } else if (type == 3) {
            imageBg.setImageResource(R.mipmap.type3);
            setTextMarginRight(dip2px(6));
            textRankLevel.setText("最强王者");
            textRankLevel.setTextColor(getResources().getColor(R.color.color_FCDCD8));
        }
    }

    public void setTextMarginRight(int marginRight) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textRankLevel.getLayoutParams();
        layoutParams.setMargins(0, 0, marginRight, 0);
        textRankLevel.setLayoutParams(layoutParams);
    }

    public int dip2px(float dipValue) {
        DisplayMetrics dm = getContext().getApplicationContext().getResources().getDisplayMetrics();
        return (int) (dipValue * dm.density + 0.5f);
    }

}
