package com.meitu.sww.testcommondialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CommonDialog commonDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickit(View view) {
        commonDialog = new CommonDialog.Builder(MainActivity.this)
                .setMessage("即将离开美颜相机 \n 前往第三方应用")
                .setPositiveButtonText("允许(3)")
                .setNegativeButtonText("取消")
                .setCancelable(true)
                .create();
        commonDialog.show();
    }

}
