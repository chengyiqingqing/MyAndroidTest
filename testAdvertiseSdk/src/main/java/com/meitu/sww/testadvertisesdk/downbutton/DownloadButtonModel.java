package com.meitu.sww.testadvertisesdk.downbutton;

import android.graphics.drawable.Drawable;

/**
 * 自定义下载按钮的样式定义Model
 * @author ShaoWenWen
 * @date 2019/4/4
 */
public class DownloadButtonModel {

    // 文字颜色和字号
    private int textColor;
    private float textSize;
    // 按钮边框宽度，边框颜色
    private float buttonStrokeWidth;
    private int buttonStrokeColor;
    // 按钮宽度，高度，背景颜色
    private float buttonWidth;
    private float buttonHeight;
    private Drawable buttonBackground;
    // 外边距margin 自己就可以控制了
//    private float marginLeft;
//    private float marginTop;
//    private float marginRight;
//    private float marginBottom;
    // 按钮背景圆角
    private float corner;

    public DownloadButtonModel() {
    }

    public DownloadButtonModel(int textColor, float textSize, float buttonStrokeWidth, int buttonStrokeColor,
            float buttonWidth, float buttonHeight, Drawable buttonBackground) {
        this.textColor = textColor;
        this.textSize = textSize;
        this.buttonStrokeWidth = buttonStrokeWidth;
        this.buttonStrokeColor = buttonStrokeColor;
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
        this.buttonBackground = buttonBackground;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public float getButtonStrokeWidth() {
        return buttonStrokeWidth;
    }

    public void setButtonStrokeWidth(float buttonStrokeWidth) {
        this.buttonStrokeWidth = buttonStrokeWidth;
    }

    public int getButtonStrokeColor() {
        return buttonStrokeColor;
    }

    public void setButtonStrokeColor(int buttonStrokeColor) {
        this.buttonStrokeColor = buttonStrokeColor;
    }

    public float getButtonWidth() {
        return buttonWidth;
    }

    public void setButtonWidth(float buttonWidth) {
        this.buttonWidth = buttonWidth;
    }

    public float getButtonHeight() {
        return buttonHeight;
    }

    public void setButtonHeight(float buttonHeight) {
        this.buttonHeight = buttonHeight;
    }

    public Drawable getButtonBackground() {
        return buttonBackground;
    }

    public void setButtonBackground(Drawable buttonBackground) {
        this.buttonBackground = buttonBackground;
    }

    public float getCorner() {
        return corner;
    }

    public void setCorner(float corner) {
        this.corner = corner;
    }

}
