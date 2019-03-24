package com.meitu.sww.testlookcrashsdk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * @author ShaoWenWen
 * @date 2019/3/13
 */
public class TestActivity extends AppCompatActivity {

    Button secondButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


    public void createCrash(View view) {
        new RuntimeException("异常信息测试demo");
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
