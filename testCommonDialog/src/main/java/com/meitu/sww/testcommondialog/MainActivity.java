package com.meitu.sww.testcommondialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DeepLinkInterceptDialog deepLinkInterceptDialog;
    private DeepLinkToast deepLinkToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickit(View view) {
        deepLinkToast = new DeepLinkToast(MainActivity.this);
        deepLinkToast.setTextToastTip(ContentType.ToastShowCountDown, 3000, false,
                new CountDownTextView.ICountDownTimeOver() {
                    @Override
                    public void countDownTimeOver() {
                        Toast.makeText(MainActivity.this, "哈哈哈", Toast.LENGTH_SHORT).show();
                    }
                });
        deepLinkToast.show();
        /*deepLinkInterceptDialog = new DeepLinkInterceptDialog.Builder(MainActivity.this)
                .setMessage("即将离开美颜相机 \n 前往第三方应用")
                .setPositiveButtonText("允许")
                .setNegativeButtonText("取消")
                .setCountDownTime(4000)
                .setCancelable(false)
                .setPositiveButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                .setNegativeButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                .create();
        deepLinkInterceptDialog.show();*/
    }

}
