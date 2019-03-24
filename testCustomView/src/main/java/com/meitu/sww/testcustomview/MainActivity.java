package com.meitu.sww.testcustomview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.meitu.sww.testcustomview.customview.TopBar;

public class MainActivity extends AppCompatActivity {

    TopBar topBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topBar = findViewById(R.id.top_bar);
        topBar.setClickOperator(new TopBar.ClickOperator() {
            @Override
            public void onClickLeft() {
                Toast.makeText(MainActivity.this,"点击左边",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickRight() {
                Toast.makeText(MainActivity.this,"点击右边",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
