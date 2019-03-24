package com.meitu.sww.testlookcrashsdk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button testClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createCrash(View view) {
        Log.e(TAG, "createCrash: " );
        testClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        new RuntimeException("走异常信息");
    }


    public void jump(View view) {
        startActivity(new Intent(MainActivity.this,TestActivity.class));
    }

}
