package com.meitu.sww.testvoicecrashsdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TestVoiceCrashSdkActivity extends AppCompatActivity {

    private static final String TAG = "TestVoiceCrashSdkActivi";
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickForCrash(View view) {
//        Log.e(TAG, "onClickForCrash:运行出一个异常出来 " );
        throw new RuntimeException("运行出一个异常出来");
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }
}
