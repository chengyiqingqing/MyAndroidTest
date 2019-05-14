package com.meitu.sww.testcommondialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatDialog;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * @author ShaoWenWen
 * @date 2019/5/14
 */
public class CommonDialog extends AppCompatDialog {

    private View layoutContent;
    private TextView textTitle;
    private TextView textMessage;
    private TextView textOk;
    private TextView textCancel;
    private View textButtonLine;

    public CommonDialog(Context context) {
        super(context);
        setDialogStyleParams();
        setContentView(R.layout.mtcp_dialog_common_hint);
        initView();
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
        layoutContent = findViewById(R.id.layout_content);
        textTitle = findViewById(R.id.text_title);
        textMessage = findViewById(R.id.text_message);
        textOk = findViewById(R.id.text_ok);
        textCancel = findViewById(R.id.text_cancel);
        textButtonLine = findViewById(R.id.view_button_line);
    }

    private void setTitle(String title) {
        if (TextUtils.isEmpty(title)) {
            textTitle.setVisibility(View.GONE);
        }
    }

    private void setMessage(String message) {
        textMessage.setText(message);
        textMessage.setVisibility(View.VISIBLE);
    }

    private void setPositiveButton(String positiveText, final View.OnClickListener positiveButtonClickListener) {
        textOk.setText(positiveText);
        textOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positiveButtonClickListener != null) positiveButtonClickListener.onClick(v);
                dismiss();
            }
        });
    }

    private void setNegativeButton(String negativeText, final View.OnClickListener negativeButtonClickListener) {
        if (TextUtils.isEmpty(negativeText)) {
            textCancel.setVisibility(View.GONE);
            textButtonLine.setVisibility(View.GONE);
            return;
        }
        textCancel.setText(negativeText);
        textCancel.setVisibility(View.VISIBLE);
        textButtonLine.setVisibility(View.VISIBLE);
        textCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (negativeButtonClickListener != null) negativeButtonClickListener.onClick(v);
                dismiss();
            }
        });
    }

    public static class Builder {

        private final Context context;
        private String title;
        private String message;
        private String positiveButtonText;
        private String negativeButtonText;
        private View.OnClickListener positiveButtonClickListener;
        private View.OnClickListener negativeButtonClickListener;
        // 点击弹窗外部区域，弹窗是否消失
        private boolean cancelable = true;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setPositiveButtonText(String positiveButtonText) {
            this.positiveButtonText = positiveButtonText;
            return this;
        }

        public Builder setNegativeButtonText(String negativeButtonText) {
            this.negativeButtonText = negativeButtonText;
            return this;
        }

        public Builder setPositiveButtonClickListener(View.OnClickListener positiveButtonClickListener) {
            this.positiveButtonClickListener = positiveButtonClickListener;
            return this;
        }

        public Builder setNegativeButtonClickListener(View.OnClickListener negativeButtonClickListener) {
            this.negativeButtonClickListener = negativeButtonClickListener;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public CommonDialog create() {
            CommonDialog dialog = new CommonDialog(context);
            dialog.setTitle(title);
            dialog.setMessage(message);
            dialog.setPositiveButton(positiveButtonText, positiveButtonClickListener);
            dialog.setNegativeButton(negativeButtonText, negativeButtonClickListener);
            dialog.setCancelable(cancelable);
            return dialog;
        }

    }

}
