package com.meitu.sww.testcustomview.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.meitu.sww.testcustomview.R;

/**
 * @author ShaoWenWen
 * @date 2019/3/17
 */
public class TopBar extends RelativeLayout {

    private TextView textContent;
    private Button leftContent;
    private Button rightContent;
    private LayoutParams leftParams, centerParams, rightParams;

    // 中间标题
    private String textTitle;
    private int textColor;
    private float textSize; // (1)这里使用的是float类型 从typedArray中获取；
    // 左边
    private String textLeftButton;
    private Drawable leftButtonDrawable; // (2)这里使用的是Drawable 从typedArray中取出；
    private float leftButtonSize;
    // 右边
    private String textRightButton;
    private Drawable rightButtonDrawable;
    private float rightButtonSize;

    private ClickOperator clickOperator;

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributeSet(context, attrs);
        initView();
        initListener();
    }

    public void initAttributeSet(Context context, AttributeSet attrs) {
        // (3)xml里所有的属性信息，都以键值对的形式存在这里面。用完要销毁的;
        // (4)获取TypedArray对象的方式：context.obtainStyledAttributes(attrs,R.styleable.xxx);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        // (5)使用R.styleable.TopBar_textTitle
        textTitle = typedArray.getString(R.styleable.TopBar_textTitle);
        textColor = typedArray.getColor(R.styleable.TopBar_textColor, 0);// (6)第二个参数怎么设置？是默认值，设置为0；
        // (7)TextSize取值方法是getFloat?  正确为getDimension，且第二个参数默认值设置为0
        textSize = typedArray.getDimension(R.styleable.TopBar_textSize, 0);

        textLeftButton = typedArray.getString(R.styleable.TopBar_textButtonLeft);
        leftButtonDrawable = typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        leftButtonSize = typedArray.getDimension(R.styleable.TopBar_leftButtonSize, 0);

        textRightButton = typedArray.getString(R.styleable.TopBar_textButtonRight);
        rightButtonDrawable = typedArray.getDrawable(R.styleable.TopBar_rightBackground);
        rightButtonSize = typedArray.getDimension(R.styleable.TopBar_rightButtonSize, 0);

        typedArray.recycle();
    }

    private void initView() {
        textContent = new TextView(getContext());
        textContent.setText(textTitle);
        textContent.setTextColor(textColor);
        textContent.setTextSize(textSize);
        textContent.setGravity(Gravity.CENTER);
        centerParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        centerParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        // (8)这里或许应该使用addView()；因为textContent还没有父控件；已经添加至父控件了，可以这样设置textContent.setLayoutParams(centerParams);
        addView(textContent, centerParams);

        leftContent = new Button(getContext());
        leftContent.setText(textLeftButton);
        leftContent.setBackground(leftButtonDrawable);
        leftContent.setTextSize(leftButtonSize);
        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(leftContent, leftParams);

        rightContent = new Button(getContext());
        rightContent.setText(textRightButton);
        rightContent.setBackground(rightButtonDrawable);
        rightContent.setTextSize(rightButtonSize);
        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(rightContent, rightParams);

    }

    private void initListener() {
        leftContent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickOperator != null) {
                    clickOperator.onClickLeft();
                }
            }
        });
        rightContent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickOperator != null) {
                    clickOperator.onClickRight();
                }
            }
        });
    }

    public void setClickOperator(ClickOperator clickOperator) {
        this.clickOperator = clickOperator;
    }

    public interface ClickOperator {
        void onClickLeft();

        void onClickRight();
    }

}
