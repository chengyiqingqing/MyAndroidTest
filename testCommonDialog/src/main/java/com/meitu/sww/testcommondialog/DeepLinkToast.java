package com.meitu.sww.testcommondialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author ShaoWenWen
 * @date 2019/5/14
 */
public class DeepLinkToast extends AppCompatDialog {

    private CountDownTextView textToastTip;
    private CountDownTextView.ICountDownTimeOver iCountDownTimeOver;

    public DeepLinkToast(Context context) {
        super(context, R.style.CustomDialog);
        setDialogStyleParams();
        setContentView(R.layout.mtcp_dialog_deep_link_toast);
        initView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setDialogStyleParams() {
        Window window = getWindow();
        if (window == null) return;
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private void initView() {
        textToastTip = findViewById(R.id.text_toast_tip);
    }

    /**
     * 设置Toast提示及监听；
     * @param contentType 内容类型；
     * @param countDownTime 倒计时
     * @param countDownTimeOver 倒计时结束监听
     */
    public void setTextToastTip(ContentType contentType, int countDownTime, boolean cancelable, CountDownTextView.ICountDownTimeOver
            countDownTimeOver) {
        textToastTip.setContentType(contentType);
        textToastTip.setCountDownTime(countDownTime);
        iCountDownTimeOver = countDownTimeOver;
        setCancelable(cancelable);
        setCanceledOnTouchOutside(cancelable);
        textToastTip.setICountDownTimeOver(new CountDownTextView.ICountDownTimeOver() {
            @Override
            public void countDownTimeOver() {
                if (iCountDownTimeOver != null) iCountDownTimeOver.countDownTimeOver();
                dismiss();
            }
        });
    }

    @Override
    public void show() {
        super.show();
        textToastTip.startCountDown();
    }

    @Override
    public void dismiss() {
        if (textToastTip != null) textToastTip.cancelCountDown();
        super.dismiss();
    }

}
